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
package com.restfb.types.ads;

import java.util.ArrayList;
import java.util.List;

import com.restfb.Facebook;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the <a href="https://developers.facebook.com/docs/marketing-api/reference/ad-asset-feed-spec-link-url/">Ad
 * Asset Feed Spec Link URL Type</a>.
 */
public class AdAssetFeedSpecLinkURL {

  private static final long serialVersionUID = 1L;

  @Getter
  @Setter
  @Facebook("adlabels")
  private List<AdAssetFeedSpecAssetLabel> adlabels = new ArrayList<>();

  @Getter
  @Setter
  @Facebook("carousel_see_more_url")
  private String carouselSeeMoreUrl;

  @Getter
  @Setter
  @Facebook("deeplink_url")
  private String deeplinkUrl;

  @Getter
  @Setter
  @Facebook("display_url")
  private String displayUrl;

  @Getter
  @Setter
  @Facebook("url_tags")
  private String urlTags;

  @Getter
  @Setter
  @Facebook("website_url")
  private String websiteUrl;
}
