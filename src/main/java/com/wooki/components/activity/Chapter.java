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

package com.wooki.components.activity;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;

import com.wooki.base.AbstractActivity;
import com.wooki.domain.model.activity.ChapterActivity;
import com.wooki.domain.model.activity.ChapterEventType;

/**
 * Display activities.
 * 
 * @author ccordenier
 * 
 */
public class Chapter extends AbstractActivity {

	@Property
	@Parameter(allowNull = false, required = true)
	private ChapterActivity activity;

	public Object[] getChapterCtx() {
		return new Object[] { activity.getChapter().getBook().getId(), activity.getChapter().getId() };
	}

	public boolean isDisplayLink() {
		return ChapterEventType.PUBLISHED.equals(activity.getType());
	}

	@SetupRender
	public boolean checkByPass() {
		return !this.activity.isResourceUnavailable();
	}

}
