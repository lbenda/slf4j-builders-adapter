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

import java.util.Iterator;

import org.apache.tools.ant.Project;
import org.slf4j.Logger;
import org.slf4j.Marker;

/** Logger adapter for maven
 * @author benzin on 2017-11-11.
 */
public class AntSlf4jAdapter implements Logger {

    private final String name;

    AntSlf4jAdapter(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isTraceEnabled() {
        return isDebugEnabled();
    }

    @Override
    public void trace(String msg) {
        debug(msg);
    }

    @Override
    public void trace(String format, Object arg) {
        debug(format, arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        debug(format, arg1, arg2);
    }

    @Override
    public void trace(String format, Object... arguments) {
        debug(format, arguments);
    }

    @Override
    public void trace(String msg, Throwable t) {
        debug(msg, t);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return true;
    }

    @Override
    public void trace(Marker marker, String msg) {
        debug(marker, msg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        debug(marker, format, arg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        debug(marker, format, arg1, arg2);
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        debug(marker, format, argArray);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        debug(marker, msg, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(String msg) {
        debug(msg, null, null);
    }

    @Override
    public void debug(String format, Object arg) {
        debug(format, arg, null);
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        debug(format, twoArgsToArray(arg1, arg2));
    }

    @Override
    public void debug(String format, Object... arguments) {
        AntSlf4jFactory.getProject().log(String.format(format, arguments), Project.MSG_DEBUG);
    }

    @Override
    public void debug(String msg, Throwable t) {
        AntSlf4jFactory.getProject().log(msg, t, Project.MSG_DEBUG);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return true;
    }

    @Override
    public void debug(Marker marker, String msg) {
        debug(marker, msg, null, null);
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        debug(marker, format, arg, null);
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        debug(marker, format, twoArgsToArray(arg1, arg2));
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        AntSlf4jFactory.getProject().log(markerToString(marker) + ": " + String.format(format, arguments), Project.MSG_DEBUG);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        AntSlf4jFactory.getProject().log(markerToString(marker) + ": " + msg, t, Project.MSG_DEBUG);
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(String msg) {
        info(msg, null, null);
    }

    @Override
    public void info(String format, Object arg) {
        info(format, arg, null);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        info(format, twoArgsToArray(arg1, arg2));
    }

    @Override
    public void info(String format, Object... arguments) {
        AntSlf4jFactory.getProject().log(String.format(format, arguments), Project.MSG_INFO);
    }

    @Override
    public void info(String msg, Throwable t) {
        AntSlf4jFactory.getProject().log(msg, t, Project.MSG_INFO);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return true;
    }

    @Override
    public void info(Marker marker, String msg) {
        info(marker, msg, null, null);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        info(marker, format, arg, null);
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        info(marker, format, twoArgsToArray(arg1, arg2));
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        AntSlf4jFactory.getProject().log(markerToString(marker) + ": " + String.format(format, arguments), Project.MSG_INFO);
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        AntSlf4jFactory.getProject().log(markerToString(marker) + ": " + msg, t, Project.MSG_INFO);
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(String msg) {
        warn(msg, null, null);
    }

    @Override
    public void warn(String format, Object arg) {
        warn(format, arg, null);
    }

    @Override
    public void warn(String format, Object... arguments) {
        AntSlf4jFactory.getProject().log(String.format(format, arguments), Project.MSG_WARN);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        warn(format, twoArgsToArray(arg1, arg2));
    }

    @Override
    public void warn(String msg, Throwable t) {
        AntSlf4jFactory.getProject().log(msg, t, Project.MSG_WARN);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return true;
    }

    @Override
    public void warn(Marker marker, String msg) {
        warn(marker, msg, null, null);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        warn(marker, format, arg, null);
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        warn(marker, format, twoArgsToArray(arg1, arg2));
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        AntSlf4jFactory.getProject().log(markerToString(marker) + ": " + String.format(format, arguments), Project.MSG_WARN);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        AntSlf4jFactory.getProject().log(markerToString(marker) + ": " + msg, t, Project.MSG_WARN);
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(String msg) {
        error(msg, null, null);
    }

    @Override
    public void error(String format, Object arg) {
        error(format, arg, null);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        error(format, twoArgsToArray(arg1, arg2));
    }

    @Override
    public void error(String format, Object... arguments) {
        AntSlf4jFactory.getProject().log(String.format(format, arguments), Project.MSG_ERR);
    }

    @Override
    public void error(String msg, Throwable t) {
        AntSlf4jFactory.getProject().log(msg, t, Project.MSG_ERR);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return true;
    }

    @Override
    public void error(Marker marker, String msg) {
        error(marker, msg, (Object) null);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        error(marker, format, arg, null);
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        error(marker, format, twoArgsToArray(arg1, arg2));
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        AntSlf4jFactory.getProject().log(markerToString(marker) + ": " + String.format(format, arguments), Project.MSG_ERR);
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        AntSlf4jFactory.getProject().log(markerToString(marker) + ": " + msg, t, Project.MSG_ERR);
    }

    private String markerToString(Marker marker) {
        StringBuilder sb = new StringBuilder();
        sb.append(marker.getName());
        for (Iterator<Marker> markerIterator = marker.iterator(); markerIterator.hasNext(); ) {
            sb.append(".").append(markerIterator.next().getName());
        }
        return sb.toString();
    }

    private Object[] twoArgsToArray(Object arg1, Object arg2) {
        return arg1 == null && arg2 == null ? new Object[0]
                : (arg1 == null ? new Object[] { arg2 } : (arg2 == null ? new Object[] { arg2 } : new Object[] { arg1, arg2 }));
    }
}

