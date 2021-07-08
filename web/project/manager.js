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


///////////////////////////////////////////////////
// 사용자 입력 정보를 Member객체를 생성
// submit 이벤트 연결



window.onload = function(){

    // 테이블 세팅
    setList();

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
    // var chk = confirm('삭제하시겠습니까?');

    // 배열의 index 요소를 삭제
    // splice(index, count)
    // index에서 시작해서 count만큼의 삭제하고 남은 요소의 배열을 반환
    // splice(index, 1)
    
    if(confirm('삭제하시겠습니까?')){
        members.splice(index, 1);
        alert('삭제되었습니다.');
        // 테이블 리스트 갱신
        setList();
    }
}

// 배열의 요소 수정 함수
function editMember(index){
    alert(index+'번 회원의 정보를 수정합니다.');
}