//
// Copyright 2009 Robin Komiwes, Bruno Verachten, Christophe Cordenier
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package com.wooki.services.security.spring;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.TapestryFilter;
import org.apache.tapestry5.internal.services.RequestImpl;
import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.ioc.services.SymbolSource;
import org.apache.tapestry5.services.ComponentEventLinkEncoder;
import org.apache.tapestry5.services.ComponentEventRequestParameters;
import org.apache.tapestry5.services.PageRenderRequestParameters;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.services.SessionPersistedObjectAnalyzer;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

/**
 * This voter will be used to secure URL access authorization.
 * 
 * @author ccordenier
 * 
 */
public class TapestryResourceVoter implements AccessDecisionVoter {

	private Map<String, TapestryResourceAccessController> ac = CollectionFactory.newCaseInsensitiveMap();

	private Registry tapestryRegistry;

	private RequestGlobals globals;

	private ComponentEventLinkEncoder encoder;

	private String applicationCharset;

	private SessionPersistedObjectAnalyzer spoa;

	public TapestryResourceVoter(Map<String, TapestryResourceAccessController> configuration) {
		if (configuration != null) {
			for (String key : configuration.keySet()) {
				ac.put(key, configuration.get(key));
			}
		}
	}

	public boolean supports(ConfigAttribute attribute) {
		if (attribute.getAttribute() != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Initialize tapestry context for spring security.
	 * 
	 * @param ctx
	 */
	private void initTapestry(ServletContext ctx) {
		this.tapestryRegistry = (Registry) ctx.getAttribute(TapestryFilter.REGISTRY_CONTEXT_NAME);
		this.encoder = this.tapestryRegistry.getService(ComponentEventLinkEncoder.class);
		this.spoa = this.tapestryRegistry.getService(SessionPersistedObjectAnalyzer.class);
		this.applicationCharset = this.tapestryRegistry.getService(SymbolSource.class).valueForSymbol(SymbolConstants.CHARSET);
		this.globals = this.tapestryRegistry.getService(RequestGlobals.class);
	}

	/**
	 * This implementation supports any type of class, because it does not query
	 * the presented secure object.
	 * 
	 * @param clazz
	 *            the secure object
	 * 
	 * @return always <code>true</code>
	 */
	public boolean supports(Class<?> clazz) {
		if (clazz == FilterInvocation.class) {
			return true;
		}
		return false;
	}

	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
		// Use Tapestry services to analyze the URL
		FilterInvocation fi = FilterInvocation.class.cast(object);
		if (tapestryRegistry == null) {
			initTapestry(fi.getHttpRequest().getSession().getServletContext());
		}
		RequestImpl request = new RequestImpl(fi.getHttpRequest(), applicationCharset, spoa);
		globals.storeRequestResponse(request, null);

		// Secure Render request
		PageRenderRequestParameters params = this.encoder.decodePageRenderRequest(request);
		if (params != null) {
			String logicalPageName = params.getLogicalPageName();
			if (this.ac.containsKey(logicalPageName)) {
				return this.ac.get(logicalPageName).isViewAuthorized(params) ? ACCESS_GRANTED : ACCESS_DENIED;
			}
		}

		// Secure action request
		ComponentEventRequestParameters actionParams = this.encoder.decodeComponentEventRequest(request);
		if (actionParams != null) {
			String logicalPageName = actionParams.getContainingPageName();
			if (this.ac.containsKey(logicalPageName)) {
				return this.ac.get(logicalPageName).isActionAuthorized(actionParams) ? ACCESS_GRANTED : ACCESS_DENIED;
			}
		}

		return ACCESS_GRANTED;
	}

}
