package org.formular.core;

import java.io.IOException;

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
					if (current == null) {
						// TODO
					}
					current = newInstance;
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
		return current.getRoot();
	};

	public static void log(String s) {
		Log.d("parsing", s);
	}
}
