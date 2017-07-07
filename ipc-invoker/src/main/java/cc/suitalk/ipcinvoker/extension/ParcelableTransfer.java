/*
 *  Copyright (C) 2017-present Albie Liang. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package cc.suitalk.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by albieliang on 2017/7/6.
 */

public class ParcelableTransfer implements BaseTypeTransfer {

    @Override
    public boolean canTransfer(Object o) {
        return o instanceof Parcelable;
    }

    @Override
    public void writeToParcel(Object o, Parcel dest) {
        Parcelable parcelable = (Parcelable) o;
        dest.writeParcelable(parcelable, 0);
    }

    @Override
    public Object readFromParcel(Parcel in) {
        return in.readParcelable(getClass().getClassLoader());
    }
}
