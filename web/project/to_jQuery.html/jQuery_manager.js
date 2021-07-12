// 회원정보 : 아이디, 비밀번호, 이름
// Member : 생성자 함수 정의
function Member(userID, userPW, userName){
    this.userID = userID;
    this.userPW = userPW;
    this.userName = userName;
}

// 객체가 가지는 메소드는 공통으로 사용 : prototype
Member.prototype.makeHtml = function(){
    return '[id:'+this.userID+' , pw:'+this.userPW+', name:'+this.userName+' ]';
};

var members = []; // new Array()


$(document).ready(function(){

    var userID = $('#userID').val();
    var userPW = $('#userPW').val();
    var chkPW = $('#chkPW').val();
    var userName = $('#userName').val();

    $('#regForm').submit(function(e){

        // 아이디 입력확인
        if (userID.trim().length < 1) {
            $('#userID+div.msg').html('필수항목입니다.');
            $('#userID+div.msg').css('display', 'block');
            return false;
        }
        // 비밀번호 입력확인
        if (userPW.trim().length < 1) {
            $('#userPW+div.msg').html('필수항목입니다.');
            $('#userPW+div.msg').css('display', 'block');
            return false;
        }
        // 비밀번호 재입력 확인
        if (chkPW.trim().length < 1) {
            $('#chkPW+div.msg').html('필수항목입니다.');
            $('#chkPW+div.msg').css('display', 'block');
            return false;
        }
        // 비밀번호 일치 확인
        if (userPW.trim() != chkPW.trim()) {
            $('#chkPW+div.msg').html('비밀번호가 일치하지 않습니다.');
            $('#chkPW+div.msg').css('display', 'block');
            return false;
        }

        // 이름 입력 확인
        if (userName.trim().length < 1) {
            $('#userName+div.msg').html('필수항목입니다.');
            $('#userName+div.msg').css('display', 'block');
            return false;
        }

    });

    $('#userID').focus(function(){
        $('#userID+div.msg').css('display', 'none');
        $('#userID+div.msg').html('');
        $('#userID').html('');
        // userID = '';
    });
    $('#userPW').focus(function(){
        $('#userPW+div.msg').css('display', 'none');
        $('#userPW+div.msg').html('');
        userPW = '';
    });
    $('#chkPW').focus(function(){
        $('#chkPW+div.msg').css('display', 'none');
        $('#chkPW+div.msg').html('');
        chkPW = '';
    });
    $('#userName').focus(function(){
        $('#userName+div.msg').css('display', 'none');
        $('#userName+div.msg').html('');
        userName = '';
    });
    


});
