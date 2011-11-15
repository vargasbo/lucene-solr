package org.apache.lucene.index.codecs.simpletext;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.util.Set;

import org.apache.lucene.index.SegmentInfo;
import org.apache.lucene.index.codecs.FieldInfosFormat;
import org.apache.lucene.index.codecs.FieldInfosReader;
import org.apache.lucene.index.codecs.FieldInfosWriter;
import org.apache.lucene.store.Directory;

/**
 * plaintext field infos format
 * <p>
 * <b><font color="red">FOR RECREATIONAL USE ONLY</font></B>
 * @lucene.experimental
 */
public class SimpleTextFieldInfosFormat extends FieldInfosFormat {
  private final FieldInfosReader reader = new SimpleTextFieldInfosReader();
  private final FieldInfosWriter writer = new SimpleTextFieldInfosWriter();

  @Override
  public FieldInfosReader getFieldInfosReader() throws IOException {
    return reader;
  }

  @Override
  public FieldInfosWriter getFieldInfosWriter() throws IOException {
    return writer;
  }

  @Override
  public void files(Directory dir, SegmentInfo info, Set<String> files) throws IOException {
    SimpleTextFieldInfosReader.files(dir, info, files);
  }
}
