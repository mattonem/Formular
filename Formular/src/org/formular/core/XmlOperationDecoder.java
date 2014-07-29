package org.formular.core;

import org.formular.operation.ParameterOperation;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.XmlResourceParser;
import android.util.Log;

public class XmlOperationDecoder {

	public static IOperation fromXML(XmlResourceParser xpp) {
		IOperation current = null;
		try {
			xpp.next();
			int eventType = xpp.getEventType();
			while (eventType != XmlResourceParser.END_DOCUMENT) {
				if (eventType == XmlResourceParser.START_TAG) {
					log("Create " + xpp.getName());
					@SuppressWarnings("unchecked")
					Class<IOperation> cls = (Class<IOperation>) Class.forName(xpp.getName());
					IOperation newInstance = cls.newInstance();
					if (current != null) {
						current.addOperand(newInstance);
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
							((ParameterOperation) newInstance).setValue(xpp.getAttributeFloatValue(i, 0f));
							
						}
					}
					
					current = newInstance;
					
				}
				if (eventType == XmlResourceParser.END_TAG) {
					log("Close " + xpp.getName());
					current = current.getParent();
				}
				eventType = xpp.next();
			}
			
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			log("ERREUR " + e.toString());
			e.printStackTrace();
		}
		log(current.getRoot().getName());
		return current.getRoot();
	};

	public static void log(String s) {
		Log.d("parsing", s);
	}
}
