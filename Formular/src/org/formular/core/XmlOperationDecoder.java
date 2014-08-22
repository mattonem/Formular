package org.formular.core;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;

public class XmlOperationDecoder {

	private static IOperation<?> _current;
	
	public static IOperation<?> fromXML(XmlResourceParser xpp) throws OperationParsingException {
		_current = null;
		try {
			xpp.next();
			int eventType = xpp.getEventType();
			while (eventType != XmlResourceParser.END_DOCUMENT) {
				String name = xpp.getName();
				if (eventType == XmlResourceParser.START_TAG) {
					log("Create " + name);
					Class<IOperation<?>> cls = findClass(name);
					IOperation<?> newInstance = cls.newInstance();
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
		log("parsing OK");
		return _current.getRoot();
	}

	private static void initializeIOperation(XmlResourceParser xpp,
			IOperation<?> newInstance) {
		if (_current != null) {
			_current.addOperand(newInstance);
		}
		Bundle bundle = new Bundle();
		for (int i = 0; i < xpp.getAttributeCount(); i++) {
			log(xpp.getAttributeName(i));
			log(xpp.getAttributeType(i));
			bundle.putString(xpp.getAttributeName(i), xpp.getAttributeValue(i));
			newInstance.initalizeWith(bundle);
		}
	}

	@SuppressWarnings("unchecked")
	private static Class<IOperation<?>> findClass(String name)
			throws ClassNotFoundException {
		Class<IOperation<?>> clazz;
		try {
			clazz = (Class<IOperation<?>>) Class.forName(name);
		} catch (ClassNotFoundException e) {
			clazz = (Class<IOperation<?>>) Class.forName("org.formular.operation.concrete." + name);
		}
		return clazz;
	};

	public static void log(String s) {
		Log.d("parsing", s);
	}
}
