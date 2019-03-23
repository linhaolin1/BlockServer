package com.lin.nettyserver.http.util.string;

public final class StringConverters {
	public static final StringConverter CONVERT_TO_INTEGER = new StringConverter() {
		public Object transform(String from) {
			return Integer.valueOf(Integer.parseInt(from));
		}
	};
	public static final StringConverter CONVERT_TO_BYTE = new StringConverter() {
		public Object transform(String from) {
			return Byte.valueOf(Byte.parseByte(from));
		}
	};
	public static final StringConverter CONVERT_TO_SHORT = new StringConverter() {
		public Object transform(String from) {
			return Short.valueOf(Short.parseShort(from));
		}
	};
	public static final StringConverter CONVERT_TO_LONG = new StringConverter() {
		public Object transform(String from) {
			return Long.valueOf(Long.parseLong(from));
		}
	};
	public static final StringConverter CONVERT_TO_FLOAT = new StringConverter() {
		public Object transform(String from) {
			return Float.valueOf(Float.parseFloat(from));
		}
	};
	public static final StringConverter CONVERT_TO_DOUBLE = new StringConverter() {
		public Object transform(String from) {
			return Double.valueOf(Double.parseDouble(from));
		}
	};
	public static final StringConverter CONVERT_TO_STRING = new StringConverter() {
		public Object transform(String from) {
			return from;
		}
	};

	public static Transformer<Class<?>, StringConverter> getCommonFactory() {
		DefaultStringConverterFactory factory = new DefaultStringConverterFactory();

		factory.setConverter(Integer.class, CONVERT_TO_INTEGER).setConverter(Byte.class, CONVERT_TO_BYTE)
				.setConverter(Short.class, CONVERT_TO_SHORT).setConverter(Long.class, CONVERT_TO_LONG)
				.setConverter(Float.class, CONVERT_TO_FLOAT).setConverter(Double.class, CONVERT_TO_DOUBLE)
				.setConverter(Integer.TYPE, CONVERT_TO_INTEGER).setConverter(Byte.TYPE, CONVERT_TO_BYTE)
				.setConverter(Short.TYPE, CONVERT_TO_SHORT).setConverter(Long.TYPE, CONVERT_TO_LONG)
				.setConverter(Float.TYPE, CONVERT_TO_FLOAT).setConverter(Double.TYPE, CONVERT_TO_DOUBLE)
				.setConverter(String.class, CONVERT_TO_STRING);

		return factory;
	}
}
