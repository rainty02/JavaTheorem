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


///////////////////////////////////////////////////
// 회원 정보를 저장하는 배열

var members = []; // new Array()

// 배열 -> JSON -> localStorage 저장
// 저장
// 수정
// 삭제
// setItem('members', JSON.stringify(members))

///////////////////////////////////////////////////
// 사용자 입력 정보를 Member객체를 생성
// submit 이벤트 연결


window.onload = function(){

    // localStorage 저장된 데이터가 있는지 확인
    // localStorage.getItem('members') 값이 없으면 null 반환
    if(localStorage.getItem('members') == null){
        // 배열 members를 저장
        localStorage.setItem('members', JSON.stringify(members)); 
    } else {
        // JSON 문자열 -> 객체 변환
        members = JSON.parse(localStorage.getItem('members')); 
        console.log(members);

        // 테이블 세팅
        setList();
    }


    var userID = document.querySelector('#userID');
    var userPW = document.querySelector('#userPW');
    var chkPW = document.querySelector('#chkPW');
    var userName = document.querySelector('#userName');

    // regForm 캐스팅
    var regForm = document.getElementById('regForm');
    regForm.onsubmit = function(){

        // 사용자가 입력한 값
        // var userID = document.querySelector('#userID').value;
        // var userPW = document.querySelector('#userPW').value;
        // var chkPW = document.querySelector('#chkPW').value;
        // var userName = document.querySelector('#userName').value;

        // 아이디 입력 확인
        if(userID.value.trim().length<1){
            // alert('이름을 입력하세요.');
            document.querySelector('#userID+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userID+div.msg').style.display = 'block';
            return false;
        };

        // 비밀번호 입력 확인
        if(userPW.value.trim().length<1){
            // alert('비밀번호를 입력하세요.');
            document.querySelector('#userPW+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userPW+div.msg').style.display = 'block';
            return false;
        }

        // 비밀번호 재입력 확인
        if(chkPW.value.trim().length<1){
            // alert('비밀번호를 입력하세요.');
            document.querySelector('#chkPW+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#chkPW+div.msg').style.display = 'block';
            return false;
        }

        // 비밀번호 일치여부
        if(userPW.value.trim() != chkPW.value.trim()){
            // alert('비밀번호가 일치하지 않습니다.\n비밀번호를 확인해주세요.');
            document.querySelector('#chkPW+div.msg').innerHTML = '비밀번호가 일치하지 않습니다.';
            document.querySelector('#chkPW+div.msg').style.display = 'block';
            // userPW.value = '';
            return false;
        }

        // 이름 입력 확인
        if(userName.value.trim().length<1){
            // alert('이름을 입력하세요.');
            document.querySelector('#userName+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userName+div.msg').style.display = 'block';
            return false;
        }

        console.log(userID.value);
        console.log(userPW.value);
        console.log(chkPW.value);
        console.log(userName.value);

        // 객체 생성
        // var member = new Member(userID.value, userPW.value, userName.value);
        // console.log(typeof memeber, member.makeHtml());

        // 배열에 사용자 정보 추가
        members.push(new Member(userID.value, userPW.value, userName.value));
        
        // 배열 저장
        localStorage.setItem('members', JSON.stringify(members));
        
        alert('등록되었습니다.');
        console.log('회원리스트', members);

        // form 초기화
        this.reset();

        // 테이블세팅
        setList();

        return false;
    }

    userID.addEventListener('focus', function(){
        document.querySelector('#userID+div.msg').style.display = 'none';
        document.querySelector('#userID+div.msg').innerHTML = '';
        userID.value = '';
    });

    userPW.addEventListener('focus', function(){
        document.querySelector('#userPW+div.msg').style.display = 'none';
        document.querySelector('#userPW+div.msg').innerHTML = '';
    });

    chkPW.addEventListener('focus', function(){
        document.querySelector('#chkPW+div.msg').style.display = 'none';
        document.querySelector('#chkPW+div.msg').innerHTML = '';
        chkPW.value = '';
    });

    userName.addEventListener('focus', function(){
        document.querySelector('#userName+div.msg').style.display = 'none';
        document.querySelector('#userName+div.msg').innerHTML = '';
    });

};

// 배열에 있는 요소를 테이블 행을 만들어 출력
function setList(){
    // table의 tbody 캐스팅
    var list = document.querySelector('#list');
    // // list의 html 코드를 tbody에 대입
    // var tbody = list.innerHTML;

    var tbody = '<tr>';
    tbody += '  <th>번호(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';


    if(members.length<1){
        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 없습니다.</td>';
        tbody += '</tr>';
    } else {

        // 반복 입력
        for(var i=0; i<members.length; i++){

            tbody += '<tr>';
            tbody += '  <td>'+i+'</td>';
            tbody += '  <td>'+members[i].userID+'</td>';
            tbody += '  <td>'+members[i].userPW+'</td>';
            tbody += '  <td>'+members[i].userName+'</td>';
            tbody += '  <td><a href="javascript:editMember('+i+')">수정</a> | <a href="javascript:deleteMember('+i+')">삭제</a></td>';
            tbody += '</tr>';
        }
    }

    list.innerHTML = tbody;

};

// 배열의 요소 삭제 함수
function deleteMember(index){
    // alert(index+'번 회원의 정보를 삭제합니다.');
    // var chk = confirm('삭제하시겠습니까?');s

    // 배열의 index 요소를 삭제
    // splice(index, count)
    // index에서 시작해서 count만큼의 삭제하고 남은 요소의 배열을 반환
    // splice(index, 1)
    
    if(confirm('삭제하시겠습니까?')){
        members.splice(index, 1);
        alert('삭제되었습니다.');

        // 배열 저장
        localStorage.setItem('members', JSON.stringify(members));

        // 테이블 리스트 갱신
        setList();
    }
}

// 배열의 요소 수정 함수
function editMember(index){

    // 수정 폼 영역 : display 변경
    document.querySelector('#editFormArea').style.display = 'block';


    // alert(index+'번 회원의 정보를 수정합니다.');

    // 전달받은 index로 members 배열의 객체를 특정할 수 있음
    // editForm의 태그의 value값을 세팅
    var editUserId = document.querySelector('#editId');
    var editUserPW = document.querySelector('#editPW');
    var editChkPW = document.querySelector('#editChkPW');
    var editUserName = document.querySelector('#editName');
    var editIndex = document.querySelector('#index');

    // 이전 데이터를 폼에 세팅
    editUserId.value = members[index].userID;
    editUserPW.value = members[index].userPW;
    editChkPW.value = members[index].userPW;
    editUserName.value = members[index].userName;
    editIndex.value = index;

    document.querySelector('#editForm').onsubmit = function(){

        // var member = new Member(editUserId.value, editUserPW.value, editUserName.value);
        // console.log(member);

        // 비밀번호 일치여부
        if(editUserPW.value != editChkPW.value){
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }


        if(!confirm('수정하시겠습니까?')){
            return false;
        }

        members[editIndex.value].userPW = editUserPW.value;
        members[editIndex.value].userName = editUserName.value;

        // 배열 저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('수정되었습니다.');

        // 테이블 세팅
        setList();

        editMemberClose();

        // alert('수정');
        
        return false;
    }

}

function editMemberClose(){
    document.querySelector('#editFormArea').style.display = 'none';
}