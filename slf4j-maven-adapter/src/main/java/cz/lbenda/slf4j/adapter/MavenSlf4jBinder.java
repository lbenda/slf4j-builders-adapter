/**
 * MIT License
 *
 * Copyright (c) 2017 Lukas "benzin" Benda
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cz.lbenda.slf4j.adapter;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/** Binder for slf4j
 * @author benzin on 2017-11-11.
 */
public class MavenSlf4jBinder implements LoggerFactoryBinder {

    /** The unique instance of this class. */
    private static final MavenSlf4jBinder SINGLETON = new MavenSlf4jBinder();

    /** Return the singleton of this class.
     * @return the StaticLoggerBinder singleton */
    public static MavenSlf4jBinder getSingleton() {
        return SINGLETON;
    }

    /** Declare the version of the SLF4J API this implementation is
     * compiled against. The value of this field is usually modified
     * with each release. */
    public static String REQUESTED_API_VERSION = "1.6";  // !final

    private static final String loggerFactoryClassStr = MavenSlf4jFactory.class.getName();

    /** The ILoggerFactory instance returned by the
     * {@link #getLoggerFactory} method should always be the same
     * object. */
    private final ILoggerFactory loggerFactory;

    private MavenSlf4jBinder() {
        loggerFactory = new MavenSlf4jFactory();
    }

    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    public String getLoggerFactoryClassStr() {
        return loggerFactoryClassStr;
    }
}
