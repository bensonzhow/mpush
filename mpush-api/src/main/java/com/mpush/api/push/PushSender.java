/*
 * (C) Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   ohun@live.cn (夜色)
 */

package com.mpush.api.push;

import com.mpush.api.protocol.Packet;
import com.mpush.api.service.Service;
import com.mpush.api.spi.SpiLoader;
import com.mpush.api.spi.client.PusherFactory;

import java.util.Collection;
import java.util.concurrent.FutureTask;

/**
 * Created by ohun on 2015/12/30.
 *
 * @author ohun@live.cn
 */
public interface PushSender extends Service {

    static PushSender create() {
        return SpiLoader.load(PusherFactory.class).get();
    }

    void send(String content, Collection<String> userIds, PushCallback callback);

    FutureTask<Boolean> send(String content, String userId, PushCallback callback);

    void send(byte[] content, Collection<String> userIds, PushCallback callback);

    FutureTask<Boolean> send(byte[] content, String userId, PushCallback callback);

    void send(byte[] content, Collection<String> userIds, AckModel ackModel, PushCallback callback);

    FutureTask<Boolean> send(byte[] content, String userId, AckModel ackModel, PushCallback callback);

}
