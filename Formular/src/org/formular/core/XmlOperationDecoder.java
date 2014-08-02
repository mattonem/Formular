package org.formular.core;

import org.formular.operation.ParameterOperation;

import android.content.res.XmlResourceParser;
import android.util.Log;

public class XmlOperationDecoder {

	private static IOperation _current;

	public static IOperation fromXML(XmlResourceParser xpp) throws OperationParsingException {
		_current = null;
		try {
			xpp.next();
			int eventType = xpp.getEventType();
			while (eventType != XmlResourceParser.END_DOCUMENT) {
				String name = xpp.getName();
				if (eventType == XmlResourceParser.START_TAG) {
					log("Create " + name);
					Class<IOperation> cls = findClass(name);
					IOperation newInstance = cls.newInstance();
					initializeIOperation(xpp, newInstance);

					_current = newInstance;

				}
				if (eventType == XmlResourceParser.END_TAG) {
					log("Close " + name);
					_current = _current.getParent();
				}
				eventType = xpp.next();
			}

		}
		catch (Exception e) {
			throw new OperationParsingException();
		}
		return _current.getRoot();
	}

	private static void initializeIOperation(XmlResourceParser xpp,
			IOperation newInstance) {
		if (_current != null) {
			_current.addOperand(newInstance);
		}
		for (int i = 0; i < xpp.getAttributeCount(); i++) {
			String attributeName = xpp.getAttributeName(i);
			log(attributeName);
			if (attributeName.equals("name")) {
				newInstance.setName(xpp.getAttributeValue(i));
			}
			if (attributeName.equals("id")) {
				newInstance.setId(xpp.getAttributeIntValue(i, 0));
			}
			if (attributeName.equals("value")) {
				((ParameterOperation) newInstance).setValue(xpp
						.getAttributeFloatValue(i, 0f));

			}
		}
	}

	@SuppressWarnings("unchecked")
	private static Class<IOperation> findClass(String name)
			throws ClassNotFoundException {
		return (Class<IOperation>) Class.forName(name);
	};

	public static void log(String s) {
		Log.d("parsing", s);
	}
}
