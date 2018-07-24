package com.angointeam.Mosaic_Server2.SignIn.VO;

public class UserVO {

        private String email;
        private String uuid;
        private String nickname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNickname() {
        return nickname;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserVO(){}
        public UserVO(String email,String uuid,String nickname){
            this.email = email;
            this.uuid = uuid;
            this.nickname = nickname;
        }

}
