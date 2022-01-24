package org.james.seventh.lecture.common.binding;

import java.util.Map;

public interface DataBinding {
	Map<String, Class<?>> getDataBinders();

}
