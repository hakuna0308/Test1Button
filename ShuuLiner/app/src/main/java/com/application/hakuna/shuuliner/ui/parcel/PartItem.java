package com.application.hakuna.shuuliner.ui.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public class PartItem implements Parcelable {

    public PartItem(Long partId, Long parenPartId, Long order, String mainText, Long openFlg, Long hasChildFlg) {
        this.partId = partId;
        this.parenPartId = parenPartId;
        this.order = order;
        this.mainText = mainText;
        this.openFlg = openFlg;
        this.hasChildFlg = hasChildFlg;
    }

    /**
     * パーツID
     */
    Long partId;
    /**
     * 親のパーツID
     */
    Long parenPartId;
    /**
     * 表示順
     */
    Long order;
    /**
     * パーツ本文
     */
    private String mainText;
    /**
     * 展開フラグ
     */
    private Long openFlg;
    /**
     * 子階層存在フラグ
     */
    private Long hasChildFlg;

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getParentPartId() {
        return parenPartId;
    }

    public void setParenPartId(Long parenPartId) {
        this.parenPartId = parenPartId;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public Long getOpenFlg() {
        return openFlg;
    }

    public void setOpenFlg(Long openFlg) {
        this.openFlg = openFlg;
    }

    public Long getHasChildFlg() {
        return hasChildFlg;
    }

    public void setHasChildFlg(Long hasChildFlg) {
        this.hasChildFlg = hasChildFlg;
    }

    // ここから Parcelable 用のテンプレート

    // 必ず read と write は同じ順番で入れること。
    public PartItem(Parcel in) {
        this.partId = in.readLong();
        this.parenPartId = in.readLong();
        this.order = in.readLong();
        this.mainText = in.readString();
        this.openFlg = in.readLong();
        this.hasChildFlg = in.readLong();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(partId);
        dest.writeLong(parenPartId);
        dest.writeLong(order);
        dest.writeString(mainText);
        dest.writeLong(openFlg);
        dest.writeLong(hasChildFlg);
    }

    // FileDescriptor を使わないときは常に 0
    public int describeContents() {
        return 0;
    }

    // これは定型文なのでそのまま使える。
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public PartItem createFromParcel(Parcel in) {
            return new PartItem(in);
        }

        public PartItem[] newArray(int size) {
            return new PartItem[size];
        }
    };
}