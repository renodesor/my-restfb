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
package com.restfb.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.restfb.AbstractJsonMapperTests;
import com.restfb.types.StoryAttachment.Image;

import org.junit.jupiter.api.Test;

import java.util.List;

class StoryAttachmentTest extends AbstractJsonMapperTests {

  @Test
  void checkImage() {
    StoryAttachment attachment =
        createJsonMapper().toJavaObject(jsonFromClasspath("v2_3/story-attachment"), StoryAttachment.class);
    assertNotNull(attachment.getMedia());
    Image image = attachment.getMedia().getImage();
    assertEquals(45, image.getHeight().intValue());
    assertEquals(175, image.getWidth().intValue());
  }

  @Test
  void checkSubAttachments() {
    StoryAttachment attachment =
        createJsonMapper().toJavaObject(jsonFromClasspath("v2_3/story-attachment"), StoryAttachment.class);
    assertNotNull(attachment.getSubAttachments());
    List<StoryAttachment> subAttachments = attachment.getSubAttachments().getData();
    assertEquals(3, subAttachments.size());
  }

  @Test
  void moreFieldsAttachments() {
    StoryAttachment attachment =
            createJsonMapper().toJavaObject(jsonFromClasspath("v3_3/story-attachment"), StoryAttachment.class);
    assertNotNull(attachment);
    assertEquals("link", attachment.getMediaType());
    assertEquals("https://translate.google.de/", attachment.getUnshimmedUrl());
  }

}
