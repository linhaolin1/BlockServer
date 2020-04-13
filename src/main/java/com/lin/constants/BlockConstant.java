package com.lin.constants;

import java.util.regex.Pattern;

public class BlockConstant {
	public static final int innerCall = 1; // 内部调用
	public static final int outerCall = 2; // 外部调用

	public static final int JavaLang = 1; // java
	public static final int CCPLUS = 2; // C/C++
	public static final int Python = 3; // python

	// public static final String belong_request = "request";
	// public static final String belong_outer = "outer";
	// public static final String belong_data = "data";
	// public static final String belong_transform = "transform";

	public static final String ARRAY_LENGTH = "array.length";

	public static final String DataSourceString = "dataSource";

	public static final int plugin_belong_sql = 1;
	public static final int plugin_belong_outer = 2;
	public static final int plugin_belong_transform = 3;

	public static final int param_type_invalid = -1;
	public static final int param_type_number = 1;
	public static final int param_type_text = 2;
	public static final int param_type_date = 3;
	public static final int param_type_list = 4;

	public static final int param_type_necessary = 0;
	public static final int param_type_optional = 1;

	public static final int args_type_input = 0;
	public static final int args_type_output = 1;

	public static final int args_type_single = 0;
	public static final int args_type_multi = 1;

	public static final int args_type_simple = 0;
	public static final int args_type_complex = 1;

	public static final String NAME_BLOCK_START = "流程Start";
	public static final String NAME_BLOCK_END = "流程End";

	public static final String REDIS_SEQUENCE = "loaddata";
	public static final String REDIS_SEQUENCE_PROCESS = "process_";

	public static final Pattern PATTERN_NAME_ARRAY = Pattern.compile("[a-zA-Z0-9_\\u4e00-\\u9fa5]+\\[[0-9]+\\]");
	public static final Pattern PATTERN_NAME_ARRAY_POSITION = Pattern.compile("\\[[0-9]+\\]");

	public static final String PROCESS_SEQUENCE_STARTCALL = "startCall";
	public static final String PROCESS_SEQUENCE_LOADCLASS = "loadClass";
	public static final String PROCESS_SEQUENCE_LOADDATA = "loadData";
	public static final String PROCESS_SEQUENCE_INVOKE = "invoke";
	public static final String PROCESS_SEQUENCE_OUTPUTDATA = "outputData";

	public static final String PROCESS_SEQUENCE_REQUEST = "receiveRequest";
	public static final String PROCESS_SEQUENCE_HANDLED = "handled";
	public static final String PROCESS_SEQUENCE_DECODEMSG = "decodeMsg";
	public static final String PROCESS_SEQUENCE_SENDEVENT = "sendEvent";
	public static final String PROCESS_SEQUENCE_PROCESS_OUT = "processOut";
	public static final String PROCESS_SEQUENCE_PROCESS_NEXT = "next";
	public static final String PROCESS_SEQUENCE_RESPONSE = "responsed";
	// public static final Pattern PATTERN_PARAM_ARRAY =
	// Pattern.compile("setArray(a-zA-Z0-9_\\u4e00-\\u9fa5]+)");
	public static final String PROPERITY_KEY_IP = "ip";
	
	public static final String PROPERITY_KEY_MSG = "RESP_MSG";
	public static final String PROPERITY_KEY_RESULT = "RESP_RESULT";
}
