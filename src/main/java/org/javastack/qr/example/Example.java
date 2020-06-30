package org.javastack.qr.example;

import java.io.FileOutputStream;
import java.util.EnumMap;
import java.util.Map;

import org.javastack.qr.BarcodeFormat;
import org.javastack.qr.BitMatrix;
import org.javastack.qr.EncodeHintType;
import org.javastack.qr.ErrorCorrectionLevel;
import org.javastack.qr.MatrixToImageWriter;
import org.javastack.qr.QRCodeWriter;

public class Example {
	public static void main(String[] args) throws Throwable {
		final Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hints.put(EncodeHintType.MARGIN, 4);
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

		final BitMatrix matrix = new QRCodeWriter().encode("Hello World", //
				BarcodeFormat.QR_CODE, //
				300, 300, // 300x300
				hints);
		FileOutputStream imageOut = new FileOutputStream("/tmp/qrcode.png");
		MatrixToImageWriter.writeToStream(matrix, "PNG", imageOut);
		imageOut.close();
	}
}
