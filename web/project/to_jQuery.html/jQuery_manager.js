// 회원정보 : 아이디, 비밀번호, 이름
// Member : 생성자 함수 정의
function Member2(userID, userPW, userName){
    this.userID = userID;
    this.userPW = userPW;
    this.userName = userName;
}

// 공통으로 사용하는 메소드
Member2.prototype.makeHtml = function(){
    return '[id:'+this.userID+' , pw:'+this.userPW+', name:'+this.userName+' ]';
};

// 객체
var members2 = [];

// html을 로드가 된 후 시작
$(document).ready(function(){

    // 저장된 데이터 여부에 따라 저장이나 반환하여 리스트 출력
    if(localStorage.getItem('members2') == null){
        localStorage.setItem('members2', JSON.stringify(members2));
    } else {
        members2 = JSON.parse(localStorage.getItem('members2')); 
        console.log(members2);
        setList();
    }

    // 캐스팅
    var userID = $('#userID');
    var userPW = $('#userPW');
    var chkPW = $('#chkPW');
    var userName = $('#userName');

    // regForm 캐스팅 후 submit 이벤트 연결
    $('#regForm').submit(function(){

        // 이메일 패턴
        var emailPtn = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;

        // 아이디(이메일) 입력확인
        if (userID.val().trim().length < 1) {
            $('#userID+div.msg').html('필수항목입니다.');
            $('#userID+div.msg').css('display', 'block');
            return false;
        }
        // 이메일 유효성
        if (!emailPtn.test(userID.val().trim())){
            $('#userID+div.msg').html('소문자, 숫자, 특수문자(".", "_", "-")를 입력하세요.');
            $('#userID+div.msg').css('display', 'block');
            return false;
        }
        // 비밀번호 입력확인
        if (userPW.val().trim().length < 1) {
            $('#userPW+div.msg').html('필수항목입니다.');
            $('#userPW+div.msg').css('display', 'block');
            return false;
        }
        // 비밀번호 재입력 확인
        if (chkPW.val().trim().length < 1) {
            $('#chkPW+div.msg').html('필수항목입니다.');
            $('#chkPW+div.msg').css('display', 'block');
            return false;
        }
        // 비밀번호 일치 확인
        if (userPW.val().trim() != chkPW.val().trim()) {
            $('#chkPW+div.msg').html('비밀번호가 일치하지 않습니다.');
            $('#chkPW+div.msg').css('display', 'block');
            return false;
        }
        // 이름 입력 확인
        if (userName.val().trim().length < 1) {
            $('#userName+div.msg').html('필수항목입니다.');
            $('#userName+div.msg').css('display', 'block');
            return false;
        }

        // 배열에 사용자 정보 추가
        members2.push(new Member2(userID.val(), userPW.val(), userName.val()));
        
        // 저장
        localStorage.setItem('members2', JSON.stringify(members2));

        alert('등록되었습니다.');

        // 배열 확인
        // console.log('회원리스트', members2);

        // form 초기화
        this.reset();

        // 테이블 갱신
        setList();
        
        return false;
    });

    // input focus 이벤트
    $('#userID').focus(function(){
        $('#userID+div.msg').css('display', 'none');
        $('#userID+div.msg').html('');
        userID.val('');
    });
    $('#userPW').focus(function(){
        $('#userPW+div.msg').css('display', 'none');
        $('#userPW+div.msg').html('');
        
    });
    $('#chkPW').focus(function(){
        $('#chkPW+div.msg').css('display', 'none');
        $('#chkPW+div.msg').html('');
        chkPW.val('');
        
    });
    $('#userName').focus(function(){
        $('#userName+div.msg').css('display', 'none');
        $('#userName+div.msg').html('');
    });   

});


// 배열을 통해 회원 리스트 html 동적 추가
function setList(){

    var tbody = '<tr>';
    tbody += '  <th>번호(index)</th>';
    tbody += '  <th>아이디(이메일)</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    if (members2.length < 1) {
        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 없습니다.</td>';
        tbody += '</tr>';
    } else {
        for (var i = 0; i < members2.length; i++) {
            tbody += '<tr>';
            tbody += '  <td>' + i + '</td>';
            tbody += '  <td>' + members2[i].userID + '</td>';
            tbody += '  <td>' + members2[i].userPW + '</td>';
            tbody += '  <td>' + members2[i].userName + '</td>';
            tbody += '  <td><a href="javascript:editMember(' + i + ')">수정</a> | <a href="javascript:deleteMember(' + i + ')">삭제</a></td>';
            tbody += '</tr>';
        }
    }

    $('#list').html(tbody);
};


// 회원정보 삭제
function deleteMember(index){

    if(confirm('삭제하시겠습니까?')){
        members2.splice(index, 1);
        alert('삭제되었습니다.');
        localStorage.setItem('members2', JSON.stringify(members2));
        setList();
    };
};

// 회원정보 수정
function editMember(index){

    // 수정폼 display 속성 변경
    $('#editFormArea').css('display', 'block');

    // 기존 정보 input value 대입
    var editIndex = $('#editIndex').val(index);
    var editUserId = $('#editId').val(members2[index].userID);
    var editUserPW = $('#editPW').val(members2[index].userPW);
    var editChkPW = $('#editChkPW').val(members2[index].userPW);
    var editUserName = $('#editName').val(members2[index].userName);

    $('#editForm').submit(function(){});

    // // editForm 캐스팅 후 submit 이벤트 연결
    $('#editForm').submit(function(){
        
        if(editUserPW.val() != editChkPW.val()){
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        };

        if(!confirm('수정하시겠습니까?')){
            return false;
        };
        
        // 변경된 값으로 배열 수정
        members2[editIndex.val()].userPW = editUserPW.val();
        members2[editIndex.val()].userName = editUserName.val();
  
        localStorage.setItem('members2', JSON.stringify(members2));

        alert('수정되었습니다.');

        // 리스트 갱신
        setList();

        // 수정폼 display 속성 변경
        editMemberClose();
        
        return false;
    });
};

// 수정폼 display 속성 변경
function editMemberClose(){
    $('#editFormArea').css('display', 'none');
};