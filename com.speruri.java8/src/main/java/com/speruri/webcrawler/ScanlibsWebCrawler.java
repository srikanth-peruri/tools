package com.speruri.webcrawler;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;

public class ScanlibsWebCrawler {

	private static String scanlibsVideosURL = "https://scanlibs.com/category/video/page/{index}/";

	private int startPageIndex;
	private int endPageIndex;

	private static int MAX_DEPTH = 2;

	private Set<String> linksVisited;
	private Set<String> articles;

	public ScanlibsWebCrawler() {
		this.linksVisited = new HashSet<>();
		this.articles = new HashSet<>();
	}

	public void crawlthePages() {
		if (startPageIndex == 0 || endPageIndex == 0) {
			return;
		}

		while (startPageIndex <= endPageIndex) {
			String urlToFetch = StringUtils.replace(scanlibsVideosURL, "{index}", String.valueOf(startPageIndex));
			linksVisited.add(urlToFetch);
			startPageIndex++;
		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		

	}
}
