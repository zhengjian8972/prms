/*
 Copyright (C) 2006 Google Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
var n=!0,r=null,z=!1;window.PR_SHOULD_USE_CONTINUATION=n;window.PR_TAB_WIDTH=8;window.PR_normalizedHtml=window.PR=window.prettyPrintOne=window.prettyPrint=void 0;window._pr_isIE6=function(){var x=navigator&&navigator.userAgent&&navigator.userAgent.match(/\bMSIE ([678])\./),x=x?+x[1]:z;window._pr_isIE6=function(){return x};return x};
(function(){function x(a){return a.replace(F,"&amp;").replace(G,"&lt;").replace(H,"&gt;")}function C(a,b,k){switch(a.nodeType){case 1:var l=a.tagName.toLowerCase();b.push("<",l);var h=a.attributes,p=h.length;if(p){if(k){for(var u=[],f=p;0<=--f;)u[f]=h[f];u.sort(function(a,b){return a.name<b.name?-1:a.name===b.name?0:1});h=u}for(f=0;f<p;++f)u=h[f],u.specified&&b.push(" ",u.name.toLowerCase(),'="',u.value.replace(F,"&amp;").replace(G,"&lt;").replace(H,"&gt;").replace(N,"&quot;"),'"')}b.push(">");for(h=
a.firstChild;h;h=h.nextSibling)C(h,b,k);(a.firstChild||!/^(?:br|link|img)$/.test(l))&&b.push("</",l,">");break;case 3:case 4:b.push(x(a.nodeValue))}}function I(a){function b(a){if("\\"!==a.charAt(0))return a.charCodeAt(0);switch(a.charAt(1)){case "b":return 8;case "t":return 9;case "n":return 10;case "v":return 11;case "f":return 12;case "r":return 13;case "u":case "x":return parseInt(a.substring(2),16)||a.charCodeAt(1);case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":return parseInt(a.substring(1),
8);default:return a.charCodeAt(1)}}function k(a){if(32>a)return(16>a?"\\x0":"\\x")+a.toString(16);a=String.fromCharCode(a);if("\\"===a||"-"===a||"["===a||"]"===a)a="\\"+a;return a}function l(a){for(var j=a.substring(1,a.length-1).match(RegExp("\\\\u[0-9A-Fa-f]{4}|\\\\x[0-9A-Fa-f]{2}|\\\\[0-3][0-7]{0,2}|\\\\[0-7]{1,2}|\\\\[\\s\\S]|-|[^-\\\\]","g")),a=[],c=[],f="^"===j[0],e=f?1:0,m=j.length;e<m;++e){var i=j[e];switch(i){case "\\B":case "\\b":case "\\D":case "\\d":case "\\S":case "\\s":case "\\W":case "\\w":a.push(i);
continue}var i=b(i),d;e+2<m&&"-"===j[e+1]?(d=b(j[e+2]),e+=2):d=i;c.push([i,d]);65>d||122<i||(65>d||90<i||c.push([Math.max(65,i)|32,Math.min(d,90)|32]),97>d||122<i||c.push([Math.max(97,i)&-33,Math.min(d,122)&-33]))}c.sort(function(a,c){return a[0]-c[0]||c[1]-a[1]});j=[];i=[NaN,NaN];for(e=0;e<c.length;++e)m=c[e],m[0]<=i[1]+1?i[1]=Math.max(i[1],m[1]):j.push(i=m);c=["["];f&&c.push("^");c.push.apply(c,a);for(e=0;e<j.length;++e)m=j[e],c.push(k(m[0])),m[1]>m[0]&&(m[1]+1>m[0]&&c.push("-"),c.push(k(m[1])));
c.push("]");return c.join("")}function h(a){for(var b=a.source.match(RegExp("(?:\\[(?:[^\\x5C\\x5D]|\\\\[\\s\\S])*\\]|\\\\u[A-Fa-f0-9]{4}|\\\\x[A-Fa-f0-9]{2}|\\\\[0-9]+|\\\\[^ux0-9]|\\(\\?[:!=]|[\\(\\)\\^]|[^\\x5B\\x5C\\(\\)\\^]+)","g")),c=b.length,d=[],e=0,f=0;e<c;++e){var i=b[e];"("===i?++f:"\\"===i.charAt(0)&&(i=+i.substring(1))&&i<=f&&(d[i]=-1)}for(e=1;e<d.length;++e)-1===d[e]&&(d[e]=++p);for(f=e=0;e<c;++e)i=b[e],"("===i?(++f,void 0===d[f]&&(b[e]="(?:")):"\\"===i.charAt(0)&&(i=+i.substring(1))&&
i<=f&&(b[e]="\\"+d[f]);for(f=e=0;e<c;++e)"^"===b[e]&&"^"!==b[e+1]&&(b[e]="");if(a.ignoreCase&&u)for(e=0;e<c;++e)i=b[e],a=i.charAt(0),2<=i.length&&"["===a?b[e]=l(i):"\\"!==a&&(b[e]=i.replace(/[a-zA-Z]/g,function(a){a=a.charCodeAt(0);return"["+String.fromCharCode(a&-33,a|32)+"]"}));return b.join("")}for(var p=0,u=z,f=z,s=0,d=a.length;s<d;++s){var v=a[s];if(v.ignoreCase)f=n;else if(/[a-z]/i.test(v.source.replace(/\\u[0-9a-f]{4}|\\x[0-9a-f]{2}|\\[^ux]/gi,""))){u=n;f=z;break}}for(var q=[],s=0,d=a.length;s<
d;++s){v=a[s];if(v.global||v.multiline)throw Error(""+v);q.push("(?:"+h(v)+")")}return RegExp(q.join("|"),f?"gi":"g")}function O(a){var b=0;return function(k){for(var l=r,h=0,p=0,u=k.length;p<u;++p){var f=k.charAt(p);switch(f){case "\t":l||(l=[]);l.push(k.substring(h,p));h=a-b%a;for(b+=h;0<=h;h-=16)l.push("                ".substring(0,h));h=p+1;break;case "\n":b=0;break;default:++b}}if(!l)return k;l.push(k.substring(h));return l.join("")}}function D(a,b,k,l){b&&(a={source:b,basePos:a},k(a),l.push.apply(l,
a.decorations))}function y(a,b){var k={},l;(function(){for(var h=a.concat(b),f=[],p={},d=0,v=h.length;d<v;++d){var q=h[d],t=q[3];if(t)for(var j=t.length;0<=--j;)k[t.charAt(j)]=q;q=q[1];t=""+q;p.hasOwnProperty(t)||(f.push(q),p[t]=r)}f.push(/[\0-\uffff]/);l=I(f)})();var h=b.length,p=function(a){for(var f=a.source,s=a.basePos,d=[s,"pln"],v=0,f=f.match(l)||[],q={},t=0,j=f.length;t<j;++t){var c=f[t],o=q[c],e=void 0,m;if("string"===typeof o)m=z;else{var i=k[c.charAt(0)];if(i)e=c.match(i[1]),o=i[0];else{for(m=
0;m<h;++m)if(i=b[m],e=c.match(i[1])){o=i[0];break}e||(o="pln")}if((m=5<=o.length&&"lang-"===o.substring(0,5))&&!(e&&"string"===typeof e[1]))m=z,o="src";m||(q[c]=o)}i=v;v+=c.length;if(m){m=e[1];var A=c.indexOf(m),g=A+m.length;e[2]&&(g=c.length-e[2].length,A=g-m.length);o=o.substring(5);D(s+i,c.substring(0,A),p,d);D(s+i+A,m,K(o,m),d);D(s+i+g,c.substring(g),p,d)}else d.push(s+i,o)}a.decorations=d};return p}function w(a){var b=[],k=[];a.tripleQuotedStrings?b.push(["str",/^(?:\'\'\'(?:[^\'\\]|\\[\s\S]|\'{1,2}(?=[^\']))*(?:\'\'\'|$)|\"\"\"(?:[^\"\\]|\\[\s\S]|\"{1,2}(?=[^\"]))*(?:\"\"\"|$)|\'(?:[^\\\']|\\[\s\S])*(?:\'|$)|\"(?:[^\\\"]|\\[\s\S])*(?:\"|$))/,
r,"'\""]):a.multiLineStrings?b.push(["str",/^(?:\'(?:[^\\\']|\\[\s\S])*(?:\'|$)|\"(?:[^\\\"]|\\[\s\S])*(?:\"|$)|\`(?:[^\\\`]|\\[\s\S])*(?:\`|$))/,r,"'\"`"]):b.push(["str",/^(?:\'(?:[^\\\'\r\n]|\\.)*(?:\'|$)|\"(?:[^\\\"\r\n]|\\.)*(?:\"|$))/,r,"\"'"]);a.verbatimStrings&&k.push(["str",/^@\"(?:[^\"]|\"\")*(?:\"|$)/,r]);var l=a.hashComments;l&&(a.cStyleComments?(1<l?b.push(["com",/^#(?:##(?:[^#]|#(?!##))*(?:###|$)|.*)/,r,"#"]):b.push(["com",/^#(?:(?:define|elif|else|endif|error|ifdef|include|ifndef|line|pragma|undef|warning)\b|[^\r\n]*)/,
r,"#"]),k.push(["str",/^<(?:(?:(?:\.\.\/)*|\/?)(?:[\w-]+(?:\/[\w-]+)+)?[\w-]+\.h|[a-z]\w*)>/,r])):b.push(["com",/^#[^\r\n]*/,r,"#"]));a.cStyleComments&&(k.push(["com",/^\/\/[^\r\n]*/,r]),k.push(["com",/^\/\*[\s\S]*?(?:\*\/|$)/,r]));a.regexLiterals&&k.push(["lang-regex",RegExp("^"+P+"(/(?=[^/*])(?:[^/\\x5B\\x5C]|\\x5C[\\s\\S]|\\x5B(?:[^\\x5C\\x5D]|\\x5C[\\s\\S])*(?:\\x5D|$))+/)")]);a=a.keywords.replace(/^\s+|\s+$/g,"");a.length&&k.push(["kwd",RegExp("^(?:"+a.replace(/\s+/g,"|")+")\\b"),r]);b.push(["pln",
/^\s+/,r," \r\n\t\u00a0"]);k.push(["lit",/^@[a-z_$][a-z_$@0-9]*/i,r],["typ",/^@?[A-Z]+[a-z][A-Za-z_$@0-9]*/,r],["pln",/^[a-z_$][a-z_$@0-9]*/i,r],["lit",/^(?:0x[a-f0-9]+|(?:\d(?:_\d+)*\d*(?:\.\d*)?|\.\d\+)(?:e[+\-]?\d+)?)[a-z]*/i,r,"0123456789"],["pun",/^.[^\s\w\.$@\'\"\`\/\#]*/,r]);return y(b,k)}function Q(a){function b(a){if(a>s){d&&d!==v&&(f.push("</span>"),d=r);!d&&v&&(d=v,f.push('<span class="',d,'">'));var b=x(j(k.substring(s,a))).replace(i?o:c,"$1&#160;");i=m.test(b);f.push(b.replace(e,w));
s=a}}var k=a.source,l=a.extractedTags,h=a.decorations,p=a.numberLines,u=a.sourceNode,f=[],s=0,d=r,v=r,q=0,t=0,j=O(window.PR_TAB_WIDTH),c=/([\r\n ]) /g,o=/(^| ) /gm,e=/\r\n?|\n/g,m=/[ \r\n]$/,i=n,g=window._pr_isIE6(),u=g?u&&"PRE"===u.tagName?6===g?"&#160;\r\n":7===g?"&#160;<br />\r":8===g?"&#160;<br />":"&#160;\r":"&#160;<br />":"<br />",w;if(p){for(var J=[],g=0;10>g;++g)J[g]=u+'</li><li class="L'+g+'">';var y="number"===typeof p?p-1:0;f.push('<ol class="linenums"><li class="L',y%10,'"');y&&f.push(' value="',
y+1,'"');f.push(">");w=function(){var a=J[++y%10];return d?"</span>"+a+'<span class="'+d+'">':a}}else w=u;for(;;)if(u=q<l.length?t<h.length?l[q]<=h[t]:n:z)b(l[q]),d&&(f.push("</span>"),d=r),f.push(l[q+1]),q+=2;else if(t<h.length)b(h[t]),v=h[t+1],t+=2;else break;b(k.length);d&&f.push("</span>");p&&f.push("</li></ol>");a.prettyPrintedHtml=f.join("")}function g(a,b){for(var k=b.length;0<=--k;){var l=b[k];B.hasOwnProperty(l)?"console"in window&&console.warn("cannot override language handler %s",l):B[l]=
a}}function K(a,b){if(!a||!B.hasOwnProperty(a))a=/^\s*</.test(b)?"default-markup":"default-code";return B[a]}function L(a){var b=a.sourceCodeHtml,k=a.langExtension;a.prettyPrintedHtml=b;try{var l,h=b.match(R),b=[],p=0,g=[];if(h)for(var f=0,s=h.length;f<s;++f){var d=h[f];if(1<d.length&&"<"===d.charAt(0)){if(!S.test(d))if(T.test(d))b.push(d.substring(9,d.length-3)),p+=d.length-12;else if(U.test(d))b.push("\n"),++p;else if(0<=d.indexOf("nocode")&&d.replace(/\s(\w+)\s*=\s*(?:\"([^\"]*)\"|'([^\']*)'|(\S+))/g,
' $1="$2$3$4"').match(/[cC][lL][aA][sS][sS]=\"[^\"]*\bnocode\b/)){var v=d.match(M)[2],q=1,t;t=f+1;a:for(;t<s;++t){var j=h[t].match(M);if(j&&j[2]===v)if("/"===j[1]){if(0===--q)break a}else++q}t<s?(g.push(p,h.slice(f,t+1).join("")),f=t):g.push(p,d)}else g.push(p,d)}else{var c;var q=d,o=q.indexOf("&");if(0>o)c=q;else{for(--o;0<=(o=q.indexOf("&#",o+1));){var e=q.indexOf(";",o);if(0<=e){var m=q.substring(o+3,e),i=10;m&&"x"===m.charAt(0)&&(m=m.substring(1),i=16);var w=parseInt(m,i);isNaN(w)||(q=q.substring(0,
o)+String.fromCharCode(w)+q.substring(e+1))}}c=q.replace(V,"<").replace(W,">").replace(X,"'").replace(Y,'"').replace(Z," ").replace($,"&")}b.push(c);p+=c.length}}l={source:b.join(""),tags:g};var y=l.source;a.source=y;a.basePos=0;a.extractedTags=l.tags;K(k,y)(a);Q(a)}catch(x){"console"in window&&console.log(x&&x.stack?x.stack:x)}}function aa(a,b,k){a={sourceCodeHtml:a,langExtension:b,numberLines:k};L(a);return a.prettyPrintedHtml}function ba(a){function b(){for(var k=window.PR_SHOULD_USE_CONTINUATION?
f.now()+250:Infinity;s<l.length&&f.now()<k;s++){var h=l[s];if(h.className&&0<=h.className.indexOf("prettyprint")){var g=h.className.match(/\blang-(\w+)\b/);g&&(g=g[1]);for(var j=z,c=h.parentNode;c;c=c.parentNode)if(("pre"===c.tagName||"code"===c.tagName||"xmp"===c.tagName)&&c.className&&0<=c.className.indexOf("prettyprint")){j=n;break}if(!j){c=h;r===E&&(j=document.createElement("PRE"),j.appendChild(document.createTextNode('<!DOCTYPE foo PUBLIC "foo bar">\n<foo />')),E=!/</.test(j.innerHTML));if(E)if(j=
c.innerHTML,"XMP"===c.tagName)j=x(j);else{if("PRE"===c.tagName||!ca.test(j))c=n;else{var o="";c.currentStyle?o=c.currentStyle.whiteSpace:window.getComputedStyle&&(o=window.getComputedStyle(c,r).whiteSpace);c=!o||"pre"===o}c||(j=j.replace(/(<br\s*\/?>)[\r\n]+/g,"$1").replace(/(?:[\r\n]+[ \t]*)+/g," "))}else{j=[];for(c=c.firstChild;c;c=c.nextSibling)C(c,j);j=j.join("")}j=j.replace(/(?:\r\n?|\n)$/,"");c=h.className.match(/\blinenums\b(?::(\d+))?/);d={sourceCodeHtml:j,langExtension:g,sourceNode:h,numberLines:c?
c[1]&&c[1].length?+c[1]:n:z};L(d);if(h=d.prettyPrintedHtml)if(g=d.sourceNode,"XMP"===g.tagName){j=document.createElement("PRE");for(c=0;c<g.attributes.length;++c)if(o=g.attributes[c],o.specified){var e=o.name.toLowerCase();"class"===e?j.className=o.value:j.setAttribute(o.name,o.value)}j.innerHTML=h;g.parentNode.replaceChild(j,g)}else g.innerHTML=h}}}s<l.length?setTimeout(b,250):a&&a()}for(var k=[document.getElementsByTagName("pre"),document.getElementsByTagName("code"),document.getElementsByTagName("xmp")],
l=[],h=0;h<k.length;++h)for(var g=0,u=k[h].length;g<u;++g)l.push(k[h][g]);var k=r,f=Date;f.now||(f={now:function(){return(new Date).getTime()}});var s=0,d;b()}var P=function(){for(var a="! != !== # % %= & && &&= &= ( * *= += , -= -> / /= : :: ; < << <<= <= = == === > >= >> >>= >>> >>>= ? @ [ ^ ^= ^^ ^^= { | |= || ||= ~ break case continue delete do else finally instanceof return throw try typeof".split(" "),b="(?:^^|[+-]",g=0;g<a.length;++g)b+="|"+a[g].replace(/([^=<>:&a-z])/g,"\\$1");return b+=")\\s*"}(),
F=/&/g,G=/</g,H=/>/g,N=/\"/g,V=/&lt;/g,W=/&gt;/g,X=/&apos;/g,Y=/&quot;/g,$=/&amp;/g,Z=/&nbsp;/g,ca=/[\r\n]/g,E=r,R=RegExp("[^<]+|<\!--[\\s\\S]*?--\>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>|</?[a-zA-Z](?:[^>\"']|'[^']*'|\"[^\"]*\")*>|<","g"),S=/^<\!--/,T=/^<!\[CDATA\[/,U=/^<br\b/i,M=/^<(\/?)([a-zA-Z][a-zA-Z0-9]*)/,da=w({keywords:"break continue do else for if return while auto case char const default double enum extern float goto int long register short signed sizeof static struct switch typedef union unsigned void volatile catch class delete false import new operator private protected public this throw true try typeof alignof align_union asm axiom bool concept concept_map const_cast constexpr decltype dynamic_cast explicit export friend inline late_check mutable namespace nullptr reinterpret_cast static_assert static_cast template typeid typename using virtual wchar_t where break continue do else for if return while auto case char const default double enum extern float goto int long register short signed sizeof static struct switch typedef union unsigned void volatile catch class delete false import new operator private protected public this throw true try typeof abstract boolean byte extends final finally implements import instanceof null native package strictfp super synchronized throws transient as base by checked decimal delegate descending dynamic event fixed foreach from group implicit in interface internal into is lock object out override orderby params partial readonly ref sbyte sealed stackalloc string select uint ulong unchecked unsafe ushort var break continue do else for if return while auto case char const default double enum extern float goto int long register short signed sizeof static struct switch typedef union unsigned void volatile catch class delete false import new operator private protected public this throw true try typeof debugger eval export function get null set undefined var with Infinity NaN caller delete die do dump elsif eval exit foreach for goto if import last local my next no our print package redo require sub undef unless until use wantarray while BEGIN END break continue do else for if return while and as assert class def del elif except exec finally from global import in is lambda nonlocal not or pass print raise try with yield False True None break continue do else for if return while alias and begin case class def defined elsif end ensure false in module next nil not or redo rescue retry self super then true undef unless until when yield BEGIN END break continue do else for if return while case done elif esac eval fi function in local set then until ",
hashComments:n,cStyleComments:n,multiLineStrings:n,regexLiterals:n}),B={};g(da,["default-code"]);g(y([],[["pln",/^[^<?]+/],["dec",/^<!\w[^>]*(?:>|$)/],["com",/^<\!--[\s\S]*?(?:-\->|$)/],["lang-",/^<\?([\s\S]+?)(?:\?>|$)/],["lang-",/^<%([\s\S]+?)(?:%>|$)/],["pun",/^(?:<[%?]|[%?]>)/],["lang-",/^<xmp\b[^>]*>([\s\S]+?)<\/xmp\b[^>]*>/i],["lang-js",/^<script\b[^>]*>([\s\S]*?)(<\/script\b[^>]*>)/i],["lang-css",/^<style\b[^>]*>([\s\S]*?)(<\/style\b[^>]*>)/i],["lang-in.tag",/^(<\/?[a-z][^<>]*>)/i]]),"default-markup,htm,html,mxml,xhtml,xml,xsl".split(","));
g(y([["pln",/^[\s]+/,r," \t\r\n"],["atv",/^(?:\"[^\"]*\"?|\'[^\']*\'?)/,r,"\"'"]],[["tag",/^^<\/?[a-z](?:[\w.:-]*\w)?|\/?>$/i],["atn",/^(?!style[\s=]|on)[a-z](?:[\w:-]*\w)?/i],["lang-uq.val",/^=\s*([^>\'\"\s]*(?:[^>\'\"\s\/]|\/(?=\s)))/],["pun",/^[=<>\/]+/],["lang-js",/^on\w+\s*=\s*\"([^\"]+)\"/i],["lang-js",/^on\w+\s*=\s*\'([^\']+)\'/i],["lang-js",/^on\w+\s*=\s*([^\"\'>\s]+)/i],["lang-css",/^style\s*=\s*\"([^\"]+)\"/i],["lang-css",/^style\s*=\s*\'([^\']+)\'/i],["lang-css",/^style\s*=\s*([^\"\'>\s]+)/i]]),
["in.tag"]);g(y([],[["atv",/^[\s\S]+/]]),["uq.val"]);g(w({keywords:"break continue do else for if return while auto case char const default double enum extern float goto int long register short signed sizeof static struct switch typedef union unsigned void volatile catch class delete false import new operator private protected public this throw true try typeof alignof align_union asm axiom bool concept concept_map const_cast constexpr decltype dynamic_cast explicit export friend inline late_check mutable namespace nullptr reinterpret_cast static_assert static_cast template typeid typename using virtual wchar_t where ",
hashComments:n,cStyleComments:n}),"c,cc,cpp,cxx,cyc,m".split(","));g(w({keywords:"null true false"}),["json"]);g(w({keywords:"break continue do else for if return while auto case char const default double enum extern float goto int long register short signed sizeof static struct switch typedef union unsigned void volatile catch class delete false import new operator private protected public this throw true try typeof abstract boolean byte extends final finally implements import instanceof null native package strictfp super synchronized throws transient as base by checked decimal delegate descending dynamic event fixed foreach from group implicit in interface internal into is lock object out override orderby params partial readonly ref sbyte sealed stackalloc string select uint ulong unchecked unsafe ushort var ",
hashComments:n,cStyleComments:n,verbatimStrings:n}),["cs"]);g(w({keywords:"break continue do else for if return while auto case char const default double enum extern float goto int long register short signed sizeof static struct switch typedef union unsigned void volatile catch class delete false import new operator private protected public this throw true try typeof abstract boolean byte extends final finally implements import instanceof null native package strictfp super synchronized throws transient ",
cStyleComments:n}),["java"]);g(w({keywords:"break continue do else for if return while case done elif esac eval fi function in local set then until ",hashComments:n,multiLineStrings:n}),["bsh","csh","sh"]);g(w({keywords:"break continue do else for if return while and as assert class def del elif except exec finally from global import in is lambda nonlocal not or pass print raise try with yield False True None ",hashComments:n,multiLineStrings:n,tripleQuotedStrings:n}),["cv","py"]);g(w({keywords:"caller delete die do dump elsif eval exit foreach for goto if import last local my next no our print package redo require sub undef unless until use wantarray while BEGIN END ",
hashComments:n,multiLineStrings:n,regexLiterals:n}),["perl","pl","pm"]);g(w({keywords:"break continue do else for if return while alias and begin case class def defined elsif end ensure false in module next nil not or redo rescue retry self super then true undef unless until when yield BEGIN END ",hashComments:n,multiLineStrings:n,regexLiterals:n}),["rb"]);g(w({keywords:"break continue do else for if return while auto case char const default double enum extern float goto int long register short signed sizeof static struct switch typedef union unsigned void volatile catch class delete false import new operator private protected public this throw true try typeof debugger eval export function get null set undefined var with Infinity NaN ",
cStyleComments:n,regexLiterals:n}),["js"]);g(w({keywords:"all and by catch class else extends false finally for if in is isnt loop new no not null of off on or return super then true try unless until when while yes ",hashComments:3,cStyleComments:n,multilineStrings:n,tripleQuotedStrings:n,regexLiterals:n}),["coffee"]);g(y([],[["str",/^[\s\S]+/]]),["regex"]);window.PR_normalizedHtml=C;window.prettyPrintOne=aa;window.prettyPrint=ba;window.PR={combinePrefixPatterns:I,createSimpleLexer:y,registerLangHandler:g,
sourceDecorator:w,PR_ATTRIB_NAME:"atn",PR_ATTRIB_VALUE:"atv",PR_COMMENT:"com",PR_DECLARATION:"dec",PR_KEYWORD:"kwd",PR_LITERAL:"lit",PR_NOCODE:"nocode",PR_PLAIN:"pln",PR_PUNCTUATION:"pun",PR_SOURCE:"src",PR_STRING:"str",PR_TAG:"tag",PR_TYPE:"typ"}})();
