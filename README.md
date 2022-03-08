# qrcode-gen

QR Code generator only, fork of [ZXing](https://github.com/zxing/zxing) barcode scanning library for Java, this is minified version. Project is Open source (Apache License, Version 2.0)

### Current Stable Version is [1.0.1](https://search.maven.org/#search|ga|1|g%3Aorg.javastack%20a%3Aqrcode-gen)

---

## DOC

#### Usage Example

```java
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
```

##### The Result:

![Hello World](https://raw.github.com/ggrandes/qrcode-gen/master/doc/qrcode.png "Hello World")

---

## MAVEN

Add the dependency to your pom.xml:

    <dependency>
        <groupId>org.javastack</groupId>
        <artifactId>qrcode-gen</artifactId>
        <version>1.0.1</version>
    </dependency>

---
Fork of [ZXing](https://github.com/zxing/zxing), this code is Java-minimalistic version.
