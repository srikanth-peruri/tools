package com.java.memory;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreemarketTemplateExample {

	public static class Table {
		private final List<FieldInfo> fieldInfoList = new ArrayList<FieldInfo>();

		public Table(FieldInfo[] argFieldInfos) {
			this.fieldInfoList.addAll(Arrays.asList(argFieldInfos));
		}

		public List<FieldInfo> getFieldInfoList() {
			return fieldInfoList;
		}

	}

	public static void main(String[] args) throws Exception {

		List<FieldInfo> fieldInfoList = new ArrayList<>();
		fieldInfoList.add(new FieldInfo("Account Name", "Account.name", "String", false, true));
		fieldInfoList.add(new FieldInfo("Account DOB", "Account.dob", "String", false, false));
		fieldInfoList.add(new FieldInfo("Account Owner ID", "Account.ownerid", "String", false, false));
		fieldInfoList.add(new FieldInfo("Account ID", "Account.id", "String", false, true));

		List<List<String>> listOfObjects = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		list1.add("Srikanth");
		list1.add("1986");
		list1.add("Jyothi");
		list1.add("SriJyo");
		listOfObjects.add(list1);

		List<String> list2 = new ArrayList<>();
		list2.add("Jyothi");
		list2.add("1989");
		list2.add("Srikanth");
		list2.add("JyoSri");
		listOfObjects.add(list2);

		List<String> list3 = new ArrayList<>();
		list3.add("Rishika");
		list3.add("2018");
		list3.add("Srikanth");
		list3.add("RishiSri");
		listOfObjects.add(list3);

		final Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(FreemarketTemplateExample.class, "");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		final Template template = cfg.getTemplate("test.ftl");

		process(template, fieldInfoList, listOfObjects);
	}

	private static void process(Template template, List<? extends Object> fieldInfoList, List<? extends Object> data)
			throws Exception {
		final Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("fieldInfoList", fieldInfoList);
		dataMap.put("resultsList", data);
		final Writer out = new OutputStreamWriter(System.out);
		template.process(dataMap, out);
		out.flush();
	}
}
