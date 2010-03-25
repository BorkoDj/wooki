INSERT INTO PUBLIC.ACCOUNTACTIVITY(TYPE, ACCOUNT_ACTIVITY_ID) VALUES (0, 1);
INSERT INTO PUBLIC.ACCOUNTACTIVITY(TYPE, ACCOUNT_ACTIVITY_ID) VALUES (0, 2);
INSERT INTO PUBLIC.ACCOUNTACTIVITY(TYPE, ACCOUNT_ACTIVITY_ID) VALUES (0, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (1, '2010-03-25 23:05:53.298000000', null, null, false, 1);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (2, '2010-03-25 23:05:53.467000000', null, null, false, 2);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (3, '2010-03-25 23:05:53.471000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (4, '2010-03-25 23:05:53.494000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (5, '2010-03-25 23:05:54.015000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (6, '2010-03-25 23:05:54.027000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (7, '2010-03-25 23:05:54.072000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (8, '2010-03-25 23:05:54.148000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (9, '2010-03-25 23:05:54.153000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (10, '2010-03-25 23:05:54.195000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (11, '2010-03-25 23:05:54.205000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (12, '2010-03-25 23:05:54.235000000', null, null, false, 3);
INSERT INTO PUBLIC.ACTIVITY(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, RESOURCEUNAVAILABLE, ID_USER) VALUES (13, '2010-03-25 23:05:54.261000000', null, null, false, 1);
INSERT INTO PUBLIC.AUTHORITY(ID, AUTHORITY) VALUES (1, 'ROLE_AUTHOR');
INSERT INTO PUBLIC.AUTHORITY(ID, AUTHORITY) VALUES (2, 'ROLE_AUTHOR');
INSERT INTO PUBLIC.AUTHORITY(ID, AUTHORITY) VALUES (3, 'ROLE_AUTHOR');
INSERT INTO PUBLIC.BOOK(ID_BOOK, CREATIONDATE, DELETIONDATE, LASTMODIFIED, SLUGTITLE, TITLE, OWNER_ID_USER) VALUES (1, '2010-03-25 23:05:53.494000000', null, '2010-03-25 23:05:53.494000000', 'the-book-of-wooki', 'The book of Wooki', 3);
INSERT INTO PUBLIC.BOOKACTIVITY(TYPE, BOOK_ACTIVITY_ID, ID_BOOK) VALUES (0, 4, 1);
INSERT INTO PUBLIC.BOOKAUTHOR(ID_BOOK, ID_USER) VALUES (1, 3);
INSERT INTO PUBLIC.BOOKAUTHOR(ID_BOOK, ID_USER) VALUES (1, 1);
INSERT INTO PUBLIC.BOOKAUTHOR(ID_BOOK, ID_USER) VALUES (1, 2);
INSERT INTO PUBLIC.CHAPTER(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, SLUGTITLE, TITLE, ID_BOOK, CHAPTER_POSITION) VALUES (1, '2010-03-25 23:05:53.494000000', null, null, 'Abstract', 'Abstract', 1, 0);
INSERT INTO PUBLIC.CHAPTER(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, SLUGTITLE, TITLE, ID_BOOK, CHAPTER_POSITION) VALUES (2, '2010-03-25 23:05:54.027000000', null, '2010-03-25 23:05:54.027000000', 'collaborative-document-publishing', 'Collaborative document publishing', 1, 1);
INSERT INTO PUBLIC.CHAPTER(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, SLUGTITLE, TITLE, ID_BOOK, CHAPTER_POSITION) VALUES (3, '2010-03-25 23:05:54.153000000', null, '2010-03-25 23:05:54.153000000', 'open-source-contribution', 'Open source contribution', 1, 2);
INSERT INTO PUBLIC.CHAPTER(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, SLUGTITLE, TITLE, ID_BOOK, CHAPTER_POSITION) VALUES (4, '2010-03-25 23:05:54.205000000', null, '2010-03-25 23:05:54.205000000', 'get-started', 'Get started', 1, 3);
INSERT INTO PUBLIC.CHAPTERACTIVITY(TYPE, CHAPTER_ACTIVITY_ID, CHAPTER_ID) VALUES (3, 5, 1);
INSERT INTO PUBLIC.CHAPTERACTIVITY(TYPE, CHAPTER_ACTIVITY_ID, CHAPTER_ID) VALUES (0, 6, 2);
INSERT INTO PUBLIC.CHAPTERACTIVITY(TYPE, CHAPTER_ACTIVITY_ID, CHAPTER_ID) VALUES (3, 7, 2);
INSERT INTO PUBLIC.CHAPTERACTIVITY(TYPE, CHAPTER_ACTIVITY_ID, CHAPTER_ID) VALUES (0, 9, 3);
INSERT INTO PUBLIC.CHAPTERACTIVITY(TYPE, CHAPTER_ACTIVITY_ID, CHAPTER_ID) VALUES (3, 10, 3);
INSERT INTO PUBLIC.CHAPTERACTIVITY(TYPE, CHAPTER_ACTIVITY_ID, CHAPTER_ID) VALUES (0, 11, 4);
INSERT INTO PUBLIC.CHAPTERACTIVITY(TYPE, CHAPTER_ACTIVITY_ID, CHAPTER_ID) VALUES (3, 12, 4);
INSERT INTO PUBLIC.COMMENT(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, CONTENT, DOMID, STATE, TITLE, LABEL_ID, PUBLICATION_ID, USER_ID_USER) VALUES (1, '2010-03-25 23:05:54.122000000', null, null, 'This is a good starting point', 'b20', 'OPEN', null, null, 2, 3);
INSERT INTO PUBLIC.COMMENT(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, CONTENT, DOMID, STATE, TITLE, LABEL_ID, PUBLICATION_ID, USER_ID_USER) VALUES (2, '2010-03-25 23:05:54.260000000', null, null, 'Wooki is really cool !', 'b10', 'OPEN', null, null, 1, 1);
INSERT INTO PUBLIC.COMMENTACTIVITY(TYPE, COMMENT_ACTIVITY_ID, COMMENT_ID) VALUES (1, 8, 1);
INSERT INTO PUBLIC.COMMENTACTIVITY(TYPE, COMMENT_ACTIVITY_ID, COMMENT_ID) VALUES (1, 13, 2);
INSERT INTO PUBLIC.PUBLICATION(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, CONTENT, PUBLISHED, ID_CHAPTER) VALUES (1, '2010-03-25 23:05:53.767000000', null, '2010-03-25 23:05:54.015000000', '<p id="b10" class="commentable">What would you need if you had to write something and share it with someone else? We think you would be looking for Wooki : a<strong>publish platform</strong>offering the possibility to have<strong>direct feedback</strong>on what you have written.</p>', true, 1);
INSERT INTO PUBLIC.PUBLICATION(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, CONTENT, PUBLISHED, ID_CHAPTER) VALUES (2, '2010-03-25 23:05:54.049000000', null, '2010-03-25 23:05:54.072000000', '<p id="b20" class="commentable">The desire to make Wooki came from a finding: we noticed that the documentation we wrote every days at work did not provide the expected result.</p><p id="b21" class="commentable">We used to produce lots of documents on multiples formats: Word, PDF, Powerpoint and of course on our intranet knowledge base.Each format used to have its inconvenient:</p><ul id="b22" class="commentable"><li>Intranet knowledge base wasn''t enough corporate</li><li>Word and PDF contents were not indexed by our intranet crawlers.</li></ul><p id="b23" class="commentable">And the worst was that we almost never had feedback on these documents. We did not knew if the produced documentation was good enough. Why?<strong>Because we did not proposed an easy way to collaborate with people</strong>.</p><p id="b24" class="commentable">Wooki''s goal is to suggest a solution to all theses problems. Of course, Wooki is not finished, that is just the beginning of the story.</p>', true, 2);
INSERT INTO PUBLIC.PUBLICATION(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, CONTENT, PUBLISHED, ID_CHAPTER) VALUES (3, '2010-03-25 23:05:54.163000000', null, '2010-03-25 23:05:54.195000000', '<p id="b30" class="commentable">We are working since many months (...years?) on the web framework Tapestry 5. In some way, we always wanted to contribute to it as some kind of "<quote>thank you</quote>".</p><p id="b31" class="commentable">Doing a project like Wooki was perfect to show the possibilities of this framework: technologies integration, ease of development.</p>', true, 3);
INSERT INTO PUBLIC.PUBLICATION(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, CONTENT, PUBLISHED, ID_CHAPTER) VALUES (4, '2010-03-25 23:05:54.225000000', null, '2010-03-25 23:05:54.235000000', '<h3 id="b40" class="commentable">Try the demo</h3><p id="b41" class="commentable">If you are reading that, you must already know that we host a demo website. You can freely:</p><ul id="b42" class="commentable"><li>create accounts</li><li>create books</li><li>export them as PDF</li></ul><h3 id="b43" class="commentable">Build Wooki directly from the source code</h3><p id="b44" class="commentable">Considering that you have already manipulated Tapestry 5 and maven, you can build the application directly from the source code.</p><p id="b45" class="commentable">Go on<a href="http://github.com/robink/wooki">Github</a>, download the sources and run jetty executing this command:</p><pre id="b46" class="commentable">mvn jetty:run</pre><p id="b47" class="commentable">Launch your browser and that''s it!</p>', true, 4);
INSERT INTO PUBLIC.PUBLICATION(ID, CREATIONDATE, DELETIONDATE, LASTMODIFIED, CONTENT, PUBLISHED, ID_CHAPTER) VALUES (5, '2010-03-25 23:05:54.247000000', null, '2010-03-25 23:05:54.248000000', '<p>What would you need if you had to write something and share it with someone else? We think you would be looking for Wooki : a <strong>publish platform</strong> offering the possibility to have <strong>direct feedback</strong> on what you have written.</p>', false, 1);
INSERT INTO PUBLIC.USER(ID_USER, CREATIONDATE, DELETIONDATE, LASTMODIFIED, EMAIL, FULLNAME, PASSWORD, USERNAME) VALUES (1, '2010-03-25 23:05:51.898000000', null, null, 'christophe@gmail.com', 'Christophe C.', 'f26c00488540ea41f52d2e216da55ecef8d063bb', 'ccordenier');
INSERT INTO PUBLIC.USER(ID_USER, CREATIONDATE, DELETIONDATE, LASTMODIFIED, EMAIL, FULLNAME, PASSWORD, USERNAME) VALUES (2, '2010-03-25 23:05:53.466000000', null, null, 'bruno@gmail.com', 'Bruno V.', 'f26c00488540ea41f52d2e216da55ecef8d063bb', 'bverachten');
INSERT INTO PUBLIC.USER(ID_USER, CREATIONDATE, DELETIONDATE, LASTMODIFIED, EMAIL, FULLNAME, PASSWORD, USERNAME) VALUES (3, '2010-03-25 23:05:53.470000000', null, null, 'robin@gmail.com', 'Robin K.', 'f26c00488540ea41f52d2e216da55ecef8d063bb', 'robink');
INSERT INTO PUBLIC.USERAUTHORITY(USER_ID_USER, AUTHORITIES_ID) VALUES (1, 1);
INSERT INTO PUBLIC.USERAUTHORITY(USER_ID_USER, AUTHORITIES_ID) VALUES (2, 2);
INSERT INTO PUBLIC.USERAUTHORITY(USER_ID_USER, AUTHORITIES_ID) VALUES (3, 3);