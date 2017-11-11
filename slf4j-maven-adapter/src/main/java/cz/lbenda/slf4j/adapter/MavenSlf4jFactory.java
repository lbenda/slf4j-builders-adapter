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

import java.util.HashMap;
import java.util.Map;

import org.apache.maven.plugin.logging.Log;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/** Adapter for logging through SLF4J to maven
 * @author lbenda on 2017-11-11.
 */
public class MavenSlf4jFactory implements ILoggerFactory {

    private static final Log NULL_LOG = new Log() {
        @Override
        public boolean isDebugEnabled() {
            return true;
        }

        @Override
        public void debug(CharSequence content) {
            System.out.println("[DEBUG] " + content);
        }

        @Override
        public void debug(CharSequence content, Throwable error) {
            System.out.println("[DEBUG] " + content);
            error.printStackTrace();
        }

        @Override
        public void debug(Throwable error) {
            System.out.print("[DEBUG] ");
            error.printStackTrace();
        }

        @Override
        public boolean isInfoEnabled() {
            return true;
        }

        @Override
        public void info(CharSequence content) {
            System.out.println("[INFO] " + content);
        }

        @Override
        public void info(CharSequence content, Throwable error) {
            System.out.println("[INFO] " + content);
            error.printStackTrace();
        }

        @Override
        public void info(Throwable error) {
            System.out.print("[INFO] ");
            error.printStackTrace();
        }

        @Override
        public boolean isWarnEnabled() {
            return true;
        }

        @Override
        public void warn(CharSequence content) {
            System.out.println("[WARN] " + content);
        }

        @Override
        public void warn(CharSequence content, Throwable error) {
            System.out.println("[WARN] " + content);
            error.printStackTrace();
        }

        @Override
        public void warn(Throwable error) {
            System.out.print("[WARN] ");
            error.printStackTrace();
        }

        @Override
        public boolean isErrorEnabled() {
            return true;
        }

        @Override
        public void error(CharSequence content) {
            System.out.println("[ERROR] " + content);
        }

        @Override
        public void error(CharSequence content, Throwable error) {
            System.out.println("[ERROR] " + content);
            error.printStackTrace();
        }

        @Override
        public void error(Throwable error) {
            System.out.print("[ERROR] ");
            error.printStackTrace();
        }
    };
    private static Log log;
    private Map<String, MavenSlf4jAdapter> loggerMap;

    public MavenSlf4jFactory() {
        loggerMap = new HashMap<>();
    }

    @Override
    public Logger getLogger(String name) {
        synchronized (loggerMap) {
            if (!loggerMap.containsKey(name)) {
                loggerMap.put(name, new MavenSlf4jAdapter(name));
            }

            return loggerMap.get(name);
        }
    }

    public static Log getLog() {
        return log == null ? NULL_LOG : log;
    }

    public static void setLog(Log log) {
        MavenSlf4jFactory.log = log;
    }
}
