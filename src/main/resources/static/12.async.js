(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[12],{"+Ll5":function(e,t,a){"use strict";var n=a("TqRt"),r=a("284h");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("+L6B");var l=n(a("2/Rp"));a("IzEo");var o=n(a("bx4M"));a("Q9mQ");var i=n(a("diRs"));a("Pwec");var u=n(a("CtXQ")),d=n(a("lwsE")),s=n(a("W8MJ")),c=n(a("a1gu")),f=n(a("Nsbk")),p=n(a("7W2i"));a("y8nQ");var v=n(a("Vl3Y"));a("iQDF");var m=n(a("+eQT"));a("OaEy");var g,h,y,E=n(a("2fM7")),w=r(a("q1tI")),b=a("MuoO"),k=n(a("WnAZ")),C=n(a("zHco")),N=n(a("LB+0")),L=n(a("HV3d")),F=(E.default.Option,m.default.RangePicker,{name:"\u4ed3\u5e93\u540d",url:"\u4ed3\u5e93\u57df\u540d",owner:"\u4ed3\u5e93\u7ba1\u7406\u5458",approver:"\u5ba1\u6279\u4eba",dateRange:"\u751f\u6548\u65e5\u671f",type:"\u4ed3\u5e93\u7c7b\u578b",name2:"\u4efb\u52a1\u540d",url2:"\u4efb\u52a1\u63cf\u8ff0",owner2:"\u6267\u884c\u4eba",approver2:"\u8d23\u4efb\u4eba",dateRange2:"\u751f\u6548\u65e5\u671f",type2:"\u4efb\u52a1\u7c7b\u578b"}),O=(g=(0,b.connect)(function(e){var t=e.assignuser,a=e.loading;return{submitting:a.effects["assignuser/updateNeedUploadList"],fetchNeedUploadListLoading:a.effects["assignuser/fetchNeedUploadList"],data:t.needUploadList}}),h=v.default.create(),g(y=h(y=function(e){function t(){var e,a;(0,d.default)(this,t);for(var n=arguments.length,r=new Array(n),l=0;l<n;l++)r[l]=arguments[l];return a=(0,c.default)(this,(e=(0,f.default)(t)).call.apply(e,[this].concat(r))),a.state={width:"100%"},a.getErrorInfo=function(){var e=a.props.form.getFieldsError,t=e(),n=Object.keys(t).filter(function(e){return t[e]}).length;if(!t||0===n)return null;var r=function(e){var t=document.querySelector('label[for="'.concat(e,'"]'));t&&t.scrollIntoView(!0)},l=Object.keys(t).map(function(e){return t[e]?w.default.createElement("li",{key:e,className:L.default.errorListItem,onClick:function(){return r(e)}},w.default.createElement(u.default,{type:"cross-circle-o",className:L.default.errorIcon}),w.default.createElement("div",{className:L.default.errorMessage},t[e][0]),w.default.createElement("div",{className:L.default.errorField},F[e])):null});return w.default.createElement("span",{className:L.default.errorIcon},w.default.createElement(i.default,{title:"\u8868\u5355\u6821\u9a8c\u4fe1\u606f",content:l,overlayClassName:L.default.errorPopover,trigger:"click",getPopupContainer:function(e){return e.parentNode}},w.default.createElement(u.default,{type:"exclamation-circle"})),n)},a.resizeFooterToolbar=function(){requestAnimationFrame(function(){var e=document.querySelectorAll(".ant-layout-sider")[0];if(e){var t="calc(100% - ".concat(e.style.width,")"),n=a.state.width;n!==t&&a.setState({width:t})}})},a.validate=function(){var e=a.props,t=e.form.validateFieldsAndScroll,n=e.dispatch;t(function(e,t){e||n({type:"assignuser/updateNeedUploadList",payload:t})})},a}return(0,p.default)(t,e),(0,s.default)(t,[{key:"componentDidMount",value:function(){var e=this.props.dispatch;e({type:"assignuser/fetchNeedUploadList"}),window.addEventListener("resize",this.resizeFooterToolbar,{passive:!0})}},{key:"componentWillUnmount",value:function(){window.removeEventListener("resize",this.resizeFooterToolbar)}},{key:"render",value:function(){var e=this.props,t=e.form.getFieldDecorator,a=e.data,n=e.submitting,r=e.fetchNeedUploadListLoading,i=this.state.width;return w.default.createElement(C.default,{title:"\u6307\u5b9a\u7528\u6237\u4e0a\u4f20\u65e5\u5fd7",content:"\u7528\u6237\u5217\u8868\u4e2d\u7684\u7528\u6237\u5c06\u4f1a\u5f00\u542f\u4e0a\u4f20\u65e5\u5fd7\u7684\u5165\u53e3",wrapperClassName:L.default.advancedForm},w.default.createElement(o.default,{title:"\u7528\u6237\u5217\u8868",bordered:!1,loading:r,style:{marginBottom:70}},t("needUploadList",{initialValue:a.needUploadList})(w.default.createElement(N.default,null))),w.default.createElement(k.default,{style:{width:i}},this.getErrorInfo(),w.default.createElement(l.default,{type:"primary",onClick:this.validate,loading:n},"\u63d0\u4ea4")))}}]),t}(w.PureComponent))||y)||y),M=O;t.default=M},HV3d:function(e,t,a){e.exports={card:"antd-pro-pages-user-log-manager-assign-user-card",heading:"antd-pro-pages-user-log-manager-assign-user-heading",steps:"antd-pro-pages-user-log-manager-assign-user-steps",errorIcon:"antd-pro-pages-user-log-manager-assign-user-errorIcon",errorPopover:"antd-pro-pages-user-log-manager-assign-user-errorPopover",errorListItem:"antd-pro-pages-user-log-manager-assign-user-errorListItem",errorField:"antd-pro-pages-user-log-manager-assign-user-errorField",editable:"antd-pro-pages-user-log-manager-assign-user-editable",advancedForm:"antd-pro-pages-user-log-manager-assign-user-advancedForm",optional:"antd-pro-pages-user-log-manager-assign-user-optional"}},JDLn:function(e,t,a){e.exports={toolbar:"antd-pro-components-footer-toolbar-index-toolbar",left:"antd-pro-components-footer-toolbar-index-left",right:"antd-pro-components-footer-toolbar-index-right"}},"LB+0":function(e,t,a){"use strict";var n=a("284h"),r=a("TqRt");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("+L6B");var l=r(a("2/Rp"));a("g9YV");var o=r(a("wCAj"));a("P2fV");var i=r(a("NJEC"));a("/zsF");var u=r(a("PArb"));a("OaEy");var d=r(a("2fM7"));a("5NDa");var s=r(a("5rEg"));a("miYZ");var c=r(a("tsqr")),f=r(a("MVZn")),p=r(a("lwsE")),v=r(a("W8MJ")),m=r(a("a1gu")),g=r(a("Nsbk")),h=r(a("7W2i")),y=n(a("q1tI")),E=r(a("Y+p1")),w=r(a("HV3d")),b=function(e){function t(e){var a;return(0,p.default)(this,t),a=(0,m.default)(this,(0,g.default)(t).call(this,e)),a.index=0,a.cacheOriginData={},a.toggleEditable=function(e,t){e.preventDefault();var n=a.state.data,r=n.map(function(e){return(0,f.default)({},e)}),l=a.getRowByKey(t,r);l&&(l.editable||(a.cacheOriginData[t]=(0,f.default)({},l)),l.editable=!l.editable,a.setState({data:r}))},a.newMember=function(){var e=a.state.data,t=e.map(function(e){return(0,f.default)({},e)}),n=Date.parse(new Date).toString();t.push({key:n,uin:"",editable:!0,isNew:!0}),a.index+=1,a.setState({data:t})},a.state={data:e.value,loading:!1,value:e.value},a}return(0,h.default)(t,e),(0,v.default)(t,[{key:"getRowByKey",value:function(e,t){var a=this.state.data;return(t||a).filter(function(t){return t.key===e})[0]}},{key:"remove",value:function(e){var t=this.state.data,a=this.props.onChange,n=t.filter(function(t){return t.key!==e});this.setState({data:n}),a(n)}},{key:"handleKeyPress",value:function(e,t){"Enter"===e.key&&this.saveRow(e,t)}},{key:"handleFieldChange",value:function(e,t,a){var n=this.state.data,r=n.map(function(e){return(0,f.default)({},e)}),l=this.getRowByKey(a,r);l&&(e.target?l[t]=e.target.value:l[t]=e,this.setState({data:r}))}},{key:"saveRow",value:function(e,t){var a=this;e.persist(),this.setState({loading:!0}),setTimeout(function(){if(a.clickedCancel)a.clickedCancel=!1;else{var n=a.getRowByKey(t)||{};if(!n.uin)return c.default.error("\u8bf7\u586b\u5199\u7528\u6237uin"),e.target.focus(),void a.setState({loading:!1});delete n.isNew,a.toggleEditable(e,t);var r=a.state.data,l=a.props.onChange;l(r),a.setState({loading:!1})}},500)}},{key:"cancel",value:function(e,t){this.clickedCancel=!0,e.preventDefault();var a=this.state.data,n=a.map(function(e){return(0,f.default)({},e)}),r=this.getRowByKey(t,n);this.cacheOriginData[t]&&(Object.assign(r,this.cacheOriginData[t]),delete this.cacheOriginData[t]),r.editable=!1,this.setState({data:n}),this.clickedCancel=!1}},{key:"render",value:function(){var e=this,t=[{title:"\u7528\u6237uin",dataIndex:"uin",key:"uin",width:"40%",render:function(t,a){return a.editable?y.default.createElement(s.default,{value:t,autoFocus:!0,onChange:function(t){return e.handleFieldChange(t,"uin",a.key)},onKeyPress:function(t){return e.handleKeyPress(t,a.key)},placeholder:"\u7528\u6237uin"}):t}},{title:"\u4e0a\u4f20\u7c7b\u578b",dataIndex:"uploadType",key:"uploadType",width:"40%",render:function(t,a){if(a.editable)return y.default.createElement(d.default,{placeholder:"\u8bf7\u9009\u62e9",style:{width:"100%"},onChange:function(t){return e.handleFieldChange(t,"uploadType",a.key)}},y.default.createElement(Option,{value:"1"},"\u9009\u62e9\u65e5\u671f\u4e0a\u4f20\u5355\u4e2a\u65e5\u5fd7"),y.default.createElement(Option,{value:"2"},"\u4e0a\u4f20\u5168\u90e8\u65e5\u5fd7"),y.default.createElement(Option,{value:"3"},"\u4e0a\u4f20\u6570\u636e\u5e93"),y.default.createElement(Option,{value:"4"},"\u4e0a\u4f20\u5168\u90e8\u65e5\u5fd7\u548c\u6570\u636e\u5e93"),y.default.createElement(Option,{value:"5"},"\u9009\u62e9\u65e5\u671f\u53d1\u9001\u5355\u4e2a\u65e5\u5fd7\u5230\u5fae\u4fe1"),y.default.createElement(Option,{value:"6"},"\u53d1\u9001\u5168\u90e8\u65e5\u5fd7\u5230\u5fae\u4fe1"),y.default.createElement(Option,{value:"7"},"\u53d1\u9001\u6570\u636e\u5e93\u5230\u5fae\u4fe1"),y.default.createElement(Option,{value:"8"},"\u53d1\u9001\u5168\u90e8\u65e5\u5fd7\u548c\u6570\u636e\u5e93\u5230\u5fae\u4fe1"));var n="\u4e0a\u4f20\u7c7b\u578b";return"1"===t?n="\u9009\u62e9\u65e5\u671f\u4e0a\u4f20\u5355\u4e2a\u65e5\u5fd7":"2"===t?n="\u4e0a\u4f20\u5168\u90e8\u65e5\u5fd7":"3"===t?n="\u4e0a\u4f20\u6570\u636e\u5e93":"4"===t?n="\u4e0a\u4f20\u5168\u90e8\u65e5\u5fd7\u548c\u6570\u636e\u5e93":"5"===t?n="\u9009\u62e9\u65e5\u671f\u53d1\u9001\u5355\u4e2a\u65e5\u5fd7\u5230\u5fae\u4fe1":"6"===t?n="\u53d1\u9001\u5168\u90e8\u65e5\u5fd7\u5230\u5fae\u4fe1":"7"===t?n="\u53d1\u9001\u6570\u636e\u5e93\u5230\u5fae\u4fe1":"8"===t&&(n="\u53d1\u9001\u5168\u90e8\u65e5\u5fd7\u548c\u6570\u636e\u5e93\u5230\u5fae\u4fe1"),n}},{title:"\u64cd\u4f5c",key:"action",render:function(t,a){var n=e.state.loading;return a.editable&&n?null:a.editable?a.isNew?y.default.createElement("span",null,y.default.createElement("a",{onClick:function(t){return e.saveRow(t,a.key)}},"\u6dfb\u52a0"),y.default.createElement(u.default,{type:"vertical"}),y.default.createElement(i.default,{title:"\u662f\u5426\u8981\u5220\u9664\u6b64\u884c\uff1f",onConfirm:function(){return e.remove(a.key)}},y.default.createElement("a",null,"\u5220\u9664"))):y.default.createElement("span",null,y.default.createElement("a",{onClick:function(t){return e.saveRow(t,a.key)}},"\u4fdd\u5b58"),y.default.createElement(u.default,{type:"vertical"}),y.default.createElement("a",{onClick:function(t){return e.cancel(t,a.key)}},"\u53d6\u6d88")):y.default.createElement("span",null,y.default.createElement("a",{onClick:function(t){return e.toggleEditable(t,a.key)}},"\u7f16\u8f91"),y.default.createElement(u.default,{type:"vertical"}),y.default.createElement(i.default,{title:"\u662f\u5426\u8981\u5220\u9664\u6b64\u884c\uff1f",onConfirm:function(){return e.remove(a.key)}},y.default.createElement("a",null,"\u5220\u9664")))}}],a=this.state,n=a.loading,r=a.data;return y.default.createElement(y.Fragment,null,y.default.createElement(o.default,{loading:n,columns:t,dataSource:r,pagination:!1,rowClassName:function(e){return e.editable?w.default.editable:""}}),y.default.createElement(l.default,{style:{width:"100%",marginTop:16,marginBottom:8},type:"dashed",onClick:this.newMember,icon:"plus"},"\u65b0\u589e\u7528\u6237"))}}],[{key:"getDerivedStateFromProps",value:function(e,t){return(0,E.default)(e.value,t.value)?null:{data:e.value,value:e.value}}}]),t}(y.PureComponent),k=b;t.default=k},WnAZ:function(e,t,a){"use strict";var n=a("284h"),r=a("TqRt");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var l=r(a("pVnL")),o=r(a("QILm")),i=r(a("lwsE")),u=r(a("W8MJ")),d=r(a("a1gu")),s=r(a("Nsbk")),c=r(a("7W2i")),f=n(a("q1tI")),p=r(a("17x9")),v=r(a("TSYQ")),m=r(a("JDLn")),g=function(e){function t(){var e,a;(0,i.default)(this,t);for(var n=arguments.length,r=new Array(n),l=0;l<n;l++)r[l]=arguments[l];return a=(0,d.default)(this,(e=(0,s.default)(t)).call.apply(e,[this].concat(r))),a.state={width:void 0},a.resizeFooterToolbar=function(){var e=document.querySelector(".ant-layout-sider");if(null!=e){var t=a.context.isMobile,n=t?null:"calc(100% - ".concat(e.style.width,")"),r=a.state.width;r!==n&&a.setState({width:n})}},a}return(0,c.default)(t,e),(0,u.default)(t,[{key:"componentDidMount",value:function(){window.addEventListener("resize",this.resizeFooterToolbar),this.resizeFooterToolbar()}},{key:"componentWillUnmount",value:function(){window.removeEventListener("resize",this.resizeFooterToolbar)}},{key:"render",value:function(){var e=this.props,t=e.children,a=e.className,n=e.extra,r=(0,o.default)(e,["children","className","extra"]),i=this.state.width;return f.default.createElement("div",(0,l.default)({className:(0,v.default)(a,m.default.toolbar),style:{width:i}},r),f.default.createElement("div",{className:m.default.left},n),f.default.createElement("div",{className:m.default.right},t))}}]),t}(f.Component);t.default=g,g.contextTypes={isMobile:p.default.bool}}}]);