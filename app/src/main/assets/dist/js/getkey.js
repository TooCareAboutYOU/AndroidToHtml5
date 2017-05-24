    //获验证取码
    var wait=30;
    var getPasscode=document.getElementById("getPassword");
    var mobile=document.getElementById("uPhone");
    var inPassword=document.getElementById('inPassword');
    var outPage=document.getElementById('outPage');
    function time(o) {
        if (wait == 0) {
            o.removeAttribute("disabled");
            o.value="获取验证码";
            wait = 60;
        } else {
            o.setAttribute("disabled", true);
            o.value="重新发送(" + wait + ")";
            wait--;
            setTimeout(function() {
                time(o)
            },
            1000)
        }
    }
    function PassCode(name){
        var url='http://app.shineup.com.cn/goldenline-portal-clt/sendDynPwdH5.html?uname=';
        var uname=name;
        url=url+uname;
        if(uname=='' || uname.length!=11){
            alert('手机号错误');
        }else if(uname.length==11){
            $.ajax({
                url:url,
                type:"post",
                dataType:'json',
                success:function (msg) {
                    alert(msg.errorMessage);
                },
                error:function () {
                    alert('网络请求失败');
                }
            });
        }
    };

    //active page
    function sucActive(a) {
        var url='';
        var infor1=Phone.value;
        var infor2=cardCode.value;
        var infor3=Cart.value;
        var infor4=activePass.value;
        url='http://app.shineup.com.cn/goldenline-portal-clt/activate.html?mobile='+infor1+"&dynPwd="+infor4+"&codeNumber="+infor3+"&codePwd="+infor2+'&uid='+a+'&token=dfdfd';
        if(infor1!='' && infor2!=''&& infor3!='' && infor4!=''){
            $.ajax({
                url:url,
                dataType:'json',
                type:'post',
                success:function (data) {
                    if(data.errorCode == 1 ){
                        alert(data.errorMessage);
                    }else if(data.errorCode == 0){
                        window.location='http://app.shineup.com.cn/goldenline/html/midAutumn/active/active-success.html';
                    }else if(data.errorCode == 3){
                        alert(data.errorMessage);
                    }
                },
                error:function () {
                    alert('网络请求失败');
                }
            })
        }else {
            alert('填完数据哦~~')
        }
    }
    function findCode() {
        PassCode(findMobile.value);
        time(this);

    }