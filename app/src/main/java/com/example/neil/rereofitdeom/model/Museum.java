package com.example.neil.rereofitdeom.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by neil on 2018/1/23.
 */

public class Museum {

    @SerializedName(value = "Data", alternate = {"email", "data"})
    private List<DataBeanX> Data;

    public List<DataBeanX> getData() {
        return Data;
    }

    public void setData(List<DataBeanX> Data) {
        this.Data = Data;
    }

    public static class DataBeanX {
        /**
         * Type : 99
         * Data : [{"Id":"c8dbfe29-572f-4a1d-aef6-5abac97b6467","Name":"聚合\u2027綻放──臺灣美術團體與美術發展","Description":"2017/10/21 ~ 2019/12/31","Description2":null,"MainFile":"https://event.culture.tw/userFiles/NTMOFA/JpgFile/01/70150/70150.jpg","MapFile":null,"IsCollect":false,"CustomAddress":"301","X":null,"Y":null,"Floor":null,"Distance":0,"PushDistance":0,"IsPush":false,"FX":null,"FY":null,"Sort":0}]
         */

        @SerializedName("Type")
        private int Type;
        @SerializedName("Data")
        private List<DataBean> Data;

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }

        public List<DataBean> getData() {
            return Data;
        }

        public void setData(List<DataBean> Data) {
            this.Data = Data;
        }

        public static class DataBean {
            /**
             * Id : c8dbfe29-572f-4a1d-aef6-5abac97b6467
             * Name : 聚合‧綻放──臺灣美術團體與美術發展
             * Description : 2017/10/21 ~ 2019/12/31
             * Description2 : null
             * MainFile : https://event.culture.tw/userFiles/NTMOFA/JpgFile/01/70150/70150.jpg
             * MapFile : null
             * IsCollect : false
             * CustomAddress : 301
             * X : null
             * Y : null
             * Floor : null
             * Distance : 0.0
             * PushDistance : 0.0
             * IsPush : false
             * FX : null
             * FY : null
             * Sort : 0
             */

            @SerializedName("Id")
            private String Id;
            @SerializedName("Name")
            private String Name;
            @SerializedName("Description")
            private String Description;
            @SerializedName("Description2")
            private Object Description2;
            @SerializedName("MainFile")
            private String MainFile;
            @SerializedName("MapFile")
            private Object MapFile;
            @SerializedName("IsCollect")
            private boolean IsCollect;
            @SerializedName("CustomAddress")
            private String CustomAddress;
            @SerializedName("X")
            private Object X;
            @SerializedName("Y")
            private Object Y;
            @SerializedName("Floor")
            private Object Floor;
            @SerializedName("Distance")
            private double Distance;
            @SerializedName("PushDistance")
            private double PushDistance;
            @SerializedName("IsPush")
            private boolean IsPush;
            @SerializedName("FX")
            private Object FX;
            @SerializedName("FY")
            private Object FY;
            @SerializedName("Sort")
            private int Sort;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public Object getDescription2() {
                return Description2;
            }

            public void setDescription2(Object Description2) {
                this.Description2 = Description2;
            }

            public String getMainFile() {
                return MainFile;
            }

            public void setMainFile(String MainFile) {
                this.MainFile = MainFile;
            }

            public Object getMapFile() {
                return MapFile;
            }

            public void setMapFile(Object MapFile) {
                this.MapFile = MapFile;
            }

            public boolean isIsCollect() {
                return IsCollect;
            }

            public void setIsCollect(boolean IsCollect) {
                this.IsCollect = IsCollect;
            }

            public String getCustomAddress() {
                return CustomAddress;
            }

            public void setCustomAddress(String CustomAddress) {
                this.CustomAddress = CustomAddress;
            }

            public Object getX() {
                return X;
            }

            public void setX(Object X) {
                this.X = X;
            }

            public Object getY() {
                return Y;
            }

            public void setY(Object Y) {
                this.Y = Y;
            }

            public Object getFloor() {
                return Floor;
            }

            public void setFloor(Object Floor) {
                this.Floor = Floor;
            }

            public double getDistance() {
                return Distance;
            }

            public void setDistance(double Distance) {
                this.Distance = Distance;
            }

            public double getPushDistance() {
                return PushDistance;
            }

            public void setPushDistance(double PushDistance) {
                this.PushDistance = PushDistance;
            }

            public boolean isIsPush() {
                return IsPush;
            }

            public void setIsPush(boolean IsPush) {
                this.IsPush = IsPush;
            }

            public Object getFX() {
                return FX;
            }

            public void setFX(Object FX) {
                this.FX = FX;
            }

            public Object getFY() {
                return FY;
            }

            public void setFY(Object FY) {
                this.FY = FY;
            }

            public int getSort() {
                return Sort;
            }

            public void setSort(int Sort) {
                this.Sort = Sort;
            }
        }
    }

}
