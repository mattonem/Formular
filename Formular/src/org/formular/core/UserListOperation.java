package org.formular.core;

import java.util.List;

public interface UserListOperation<O> extends Input<Integer>, ParameterList<O> {

	Integer selected();

	List<?> getList();

}
