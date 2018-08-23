package com.speruri.webcrawler;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebCrawlerThread<V> implements Callable<String> {

	private String urlToFetch;
	private List<String> domPathList;
	private int depthTofetch = 1;
	private StringBuilder finalresponseGenerated;
	private Queue<String> linkQueue;

	public WebCrawlerThread(String urlToFetch, List<String> domPath, int depthTofetch) {
		super();
		this.urlToFetch = urlToFetch;
		this.domPathList = domPath;
		this.depthTofetch = depthTofetch;
		this.finalresponseGenerated = new StringBuilder();
		this.linkQueue = new LinkedBlockingQueue<>();
	}

	@Override
	public String call() throws Exception {
		if (urlToFetch != null && !urlToFetch.isEmpty()) {
			domPathList.forEach((path) -> linkQueue.add(path));
			findLinksAndCrawl(urlToFetch, depthTofetch, linkQueue.poll());
		}
		return null;
	}

	private void findLinksAndCrawl(String argUrlToFetch, int argDepthTofetch, String argDomPath) {
		if (argDepthTofetch == 0 || argUrlToFetch == null || argUrlToFetch.isEmpty() || argDomPath == null
				|| argDomPath.isEmpty()) {
			return;
		}
		try {
			Document document = Jsoup.connect(argUrlToFetch).get();
			Elements element = document.select(argDomPath);
			findLinksAndCrawl(element.text(), argDepthTofetch - 1, linkQueue.poll());
		} catch (Exception e) {
			throw new RuntimeException("unable to crawl the page : ", e);
		}
	}

}
