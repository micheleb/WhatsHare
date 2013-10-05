/**
 * AnalyticsExceptionParser.java Created on 2 Jul 2013
 * 
 * Copyright 2013 Michele Bonazza <emmepuntobi@gmail.com>
 * 
 * This file is part of WhatsHare.
 * 
 * WhatsHare is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Foobar is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * WhatsHare. If not, see <http://www.gnu.org/licenses/>.
 */
package it.mb.whatshare;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.google.analytics.tracking.android.ExceptionParser;

/**
 * Overrides Analytics suboptimal exception tracking system, which only logs the
 * first line in the stack trace.
 * 
 * @author Michele Bonazza
 * 
 */
public class AnalyticsExceptionParser implements ExceptionParser {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.google.analytics.tracking.android.ExceptionParser#getDescription(
     * java.lang.String, java.lang.Throwable)
     */
    @Override
    public String getDescription(String arg0, Throwable arg1) {
        // @formatter:off
        StringWriter writer = new StringWriter();
        arg1.printStackTrace(new PrintWriter(writer));
        return new StringBuilder("Thread: ")
                    .append(arg0)
                    .append(", Exception: ")
                    .append(writer.toString())
                    .toString();
    }

}
