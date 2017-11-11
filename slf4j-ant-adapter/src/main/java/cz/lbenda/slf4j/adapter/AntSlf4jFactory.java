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

import org.apache.tools.ant.Project;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/** Adapter for logging through SLF4J to maven
 * @author lbenda on 2017-11-11.
 */
public class AntSlf4jFactory implements ILoggerFactory {

    private static Project project;
    private Map<String, AntSlf4jAdapter> loggerMap;

    public AntSlf4jFactory() {
        loggerMap = new HashMap<>();
    }

    @Override
    public Logger getLogger(String name) {
        synchronized (loggerMap) {
            if (!loggerMap.containsKey(name)) {
                loggerMap.put(name, new AntSlf4jAdapter(name));
            }

            return loggerMap.get(name);
        }
    }

    public static Project getProject() {
        return project;
    }

    public static void setProject(Project project) {
        AntSlf4jFactory.project = project;
    }
}
