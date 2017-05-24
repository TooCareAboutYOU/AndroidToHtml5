/**
 * Created by Administrator on 2016/9/8.
 */
window.onload = function () {
        var u = navigator.userAgent;
        var theHeader=document.createElement('nav');
        var theDiv=document.createElement('div');
        var theB=document.createElement('b');
        var First=document.body.firstChild;
        if (u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) {//安卓手机
            theDiv.setAttribute('onclick','history.go(-1)');
            theDiv.setAttribute('class','historyback pull-left');
            theHeader.setAttribute('class','header');
            theDiv.innerHTML='<img src="img/historyback1.png" alt="">';
            theB.innerHTML='星咖之夜抽奖活动';
            theHeader.appendChild(theDiv);
            theHeader.appendChild(theB);
            document.body.insertBefore(theHeader,First);
        } else if (u.indexOf('iPhone') > -1) {//苹果手机
            theDiv.setAttribute('onclick','history.go(-1)');
            theDiv.setAttribute('class','historyback pull-left');
            theHeader.setAttribute('class','header');
            theDiv.innerHTML='<img src="img/historyback1.png" alt="">';
            theB.innerHTML='星咖之夜抽奖活动';
            theHeader.appendChild(theDiv);
            theHeader.appendChild(theB);
            document.body.insertBefore(theHeader,First);
        } else if (u.indexOf('Windows Phone') > -1) {//winphone手机

        }
    };