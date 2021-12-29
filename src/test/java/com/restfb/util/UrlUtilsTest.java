/*
 * Copyright (c) 2010-2021 Mark Allen, Norbert Bartels.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.restfb.util;

import static com.restfb.util.UrlUtils.extractParametersFromQueryString;
import static com.restfb.util.UrlUtils.extractParametersFromUrl;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Unit tests that exercise {@link com.restfb.util.UrlUtils}.
 * 
 * @author <a href="http://restfb.com">Mark Allen</a>
 */
class UrlUtilsTest {

  @Test
  void urlEncode_null() {
    assertThat(UrlUtils.urlEncode(null)).isNull();
  }

  @Test
  void urlEncode_string() {
    assertThat(UrlUtils.urlEncode("This is a string")).isEqualTo("This+is+a+string");
  }

  @Test
  void urlDecode_null() {
    assertThat(UrlUtils.urlDecode(null)).isNull();
  }

  @Test
  void urlDecode_string() {
    assertThat(UrlUtils.urlDecode("This+is+a+string")).isEqualTo("This is a string");
  }

  @Test
  void queryString() {
    assertThat(extractParametersFromQueryString(null)).isEmpty();
    assertThat(extractParametersFromQueryString("")).isEmpty();
    assertThat(extractParametersFromQueryString("access_token=123")).hasSize(1);
    assertThat(extractParametersFromQueryString("?access_token=123")).hasSize(1);
  }

  @Test
  void urlParameters() {
    assertThat(extractParametersFromUrl(null)).isEmpty();
    assertThat(extractParametersFromUrl("")).isEmpty();
    assertThat(extractParametersFromUrl("access_token=123")).isEmpty();
    assertThat(extractParametersFromUrl("?access_token=123")).hasSize(1);
    assertThat(extractParametersFromUrl("http://whatever?access_token=123")).hasSize(1);
  }

  @Test
  void replaceParameter() {
    String exampleUrl = "http://www.example.com?access_token=123&before=1234";
    String resultURL = UrlUtils.replaceOrAddQueryParameter(exampleUrl, "before", "56789");
    String expectedURL = "http://www.example.com?access_token=123&before=56789";
    assertThat(resultURL).isEqualTo(expectedURL);
  }

  @Test
  void removeParameter_lastParameter() {
    String exampleUrl = "http://www.example.com?access_token=123&before=1234";
    String resultURL = UrlUtils.removeQueryParameter(exampleUrl, "before");
    String expectedURL = "http://www.example.com?access_token=123";
    assertThat(resultURL).isEqualTo(expectedURL);
  }

  @Test
  void removeParameter_firstParameter() {
    String exampleUrl = "http://www.example.com?access_token=123&before=1234";
    String resultURL = UrlUtils.removeQueryParameter(exampleUrl, "access_token");
    String expectedURL = "http://www.example.com?before=1234";
    assertThat(resultURL).isEqualTo(expectedURL);
  }

  @Test
  void removeParameter_middleParameter() {
    String exampleUrl = "http://www.example.com?access_token=123&first=6543&before=1234";
    String resultURL = UrlUtils.removeQueryParameter(exampleUrl, "first");
    String expectedURL = "http://www.example.com?access_token=123&before=1234";
    assertThat(resultURL).isEqualTo(expectedURL);
  }

  @Test
  void addParameterNoParameter() {
    String exampleUrl = "http://www.example.com";
    String resultURL = UrlUtils.replaceOrAddQueryParameter(exampleUrl, "before", "56789");
    String expectedURL = "http://www.example.com?before=56789";
    assertThat(resultURL).isEqualTo(expectedURL);
  }

  @Test
  void addParameter() {
    String exampleUrl = "http://www.example.com?access_token=123";
    String resultURL = UrlUtils.replaceOrAddQueryParameter(exampleUrl, "before", "56789");
    String expectedURL = "http://www.example.com?access_token=123&before=56789";
    assertThat(resultURL).isEqualTo(expectedURL);
  }
}