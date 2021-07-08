// 회원정보 : 아이디, 비밀번호, 이름
// Member : 생성자 함수 정의
function Member(){
    this.userID = id;
    this.userPW = pw;
    this.userName = name;
}

// 객체가 가지는 메소드는 공통으로 사용 : prototype
Member.prototype.makeHtml = function(){
    return '[id:'+this.userID+' , pw:'+this.userPW+', name:'+this.userName+' ]';
};


///////////////////////////////////////////////////
// 사용자 입력 정보를 Member객체를 생성
// submit 이벤트 연결

window.onload = function(){
    // regForm 캐스팅
    var regForm = document.getElementById('regForm');
    regForm.onsubmit = function(){

        // 사용자가 입력한 값 확인
        var userID = document.querySelector('#userID').value;
        var userPW = document.querySelector('#userPW').value;
        var chkPW = document.querySelector('#chkPW').value;
        var userName = document.querySelector('#userName').value;

        // // 아이디 입력 확인
        // if(userID.trim().length<1){
        //     alert('이름을 입력하세요.');
        //     return false;
        // };

        // // 비밀번호 입력 확인
        // if(userPW.trim().length<1 || chkPW.trim().length<1){
        //     alert('비밀번호를 입력하세요.');
        //     return false;
        // }

        // // 비밀번호 일치여부
        // if(userPW.trim() != chkPW.trim()){
        //     alert('비밀번호가 일치하지 않습니다.\n비밀번호를 확인해주세요.');
        //     return false;
        // }

        // // 이름 입력 확인
        // if(userName.trim().length<1){
        //     alert('이름을 입력하세요.');
        //     return false;
        // }

        console.log(userID);
        console.log(userPW);
        console.log(chkPW);
        console.log(userName);

        var member = new Member(userID, userPW, userName);

        console.log(typeof memeber, member.makeHtml);



        return false;
    }
};