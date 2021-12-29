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

import static com.restfb.testutils.RestfbAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.restfb.AbstractJsonMapperTests;

public class ConversationTest extends AbstractJsonMapperTests {

  @Test
  void checkV10_instagram() {
    Conversation instaConversation = createJsonMapper().toJavaObject(jsonFromClasspath("v10_0/instagram-conversation"), Conversation.class);
    assertThat(instaConversation).isNotNull();
    assertThat(instaConversation.getParticipants()).isNotNull();
    assertThat(instaConversation.getParticipants()).isNotEmpty();
    for (ExtendedReferenceType refType : instaConversation.getParticipants()) {
      assertThat(refType.getUserId()).isEqualTo("<IGID>");
      assertThat(refType.getUsername()).isEqualTo("<IG_USER_NAME>");
      assertThat(refType.getId()).isIn("<IGID>","<IGSID>");
      assertThat(refType.isInstagram()).isTrue();
    }
  }
}
