package com.bhcj.telling;
public class TarotCard {
    public int drawableId;     // 图片资源ID
    public String name;        // 牌名
    public String upright;     // 正位含义
    public String reversed;    // 逆位含义

    public TarotCard(int drawableId, String name, String upright, String reversed) {
        this.drawableId = drawableId;
        this.name = name;
        this.upright = upright;
        this.reversed = reversed;
    }
}