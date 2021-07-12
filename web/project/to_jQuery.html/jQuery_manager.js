// 회원정보 : 아이디, 비밀번호, 이름
// Member : 생성자 함수 정의
function Member2(userID, userPW, userName){
    this.userID = userID;
    this.userPW = userPW;
    this.userName = userName;
}

// 객체가 가지는 메소드는 공통으로 사용 : prototype
// Member2.prototype.makeHtml = function(){
//     return '[id:'+this.userID+' , pw:'+this.userPW+', name:'+this.userName+' ]';
// };

var members2 = []; // new Array()


$(document).ready(function(){

    // if(localStorage.getItem('members2') == null){
    //     localStorage.setItem('members2', JSON.stringify(members2));
    // } else {
    //     members2 = JSON.parse(localStorage.getItem('members2')); 
    //     console.log(members2);
    //     setList();
    // }

    var userID = $('#userID');
    var userPW = $('#userPW');
    var chkPW = $('#chkPW');
    var userName = $('#userName');

    $('#regForm').submit(function(){
        
        // 아이디 입력확인
        if (userID.val().trim().length < 1) {
            $('#userID+div.msg').html('필수항목입니다.');
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
        
        console.log('아이디', userID.val());
        console.log('패스워드', userPW.val());
        console.log('패스워드 확인', chkPW.val());
        console.log('네임', userName.val());
        

        // 배열에 사용자 정보 추가
        members2.push(new Member2(userID.val(), userPW.val(), userName.val()));

        console.log(members2);
        
        // localStorage.setItem('members2', JSON.stringify(members2));

        alert('등록되었습니다.');
        console.log('회원리스트', members2);

        // form 초기화
        this.reset();

        // 테이블 세팅
        setList();
        
        return false;

    });

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


// 배열에 있는 요소를 테이블 행을 만들어 출력
function setList(){

    var tbody = '<tr>';
    tbody += '  <th>번호(index)</th>';
    tbody += '  <th>아이디</th>';
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


// 삭제
function deleteMember(index){
    if(confirm('삭제하시겠습니까?')){
        members2.splice(index, 1);
        alert('삭제되었습니다.');
        setList();
    };
};

function editMember(index){

    $('#editFormArea').css('display', 'block');

    $('#editIndex').val() = index;
    $('#editId').val() = members2[index].userID;
    $('#editPW').val() = members2[index].userPW;
    $('#editchkPW').val() = members2[index].chkPW;
    $('#editName').val() = members2[index].userName;

    $('editForm').submit(function(){

        if($('#editPW').val() != $('#editchkPW').val()){
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }
    });
}