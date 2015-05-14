if (typeof String.prototype.startsWith != 'function') {
	// see below for better implementation!
	String.prototype.startsWith = function(str) {
		return this.indexOf(str) == 0;
	};
}

var envCompleter = {

	findPrefix : function(session, pos) {

		var text = session.getLine(pos.row);
		var buf = [];
		for ( var i = pos.column - 1; i >= 0; i--) {
			if (this.identifierRegexps[0].test(text[i]))
				buf.push(text[i]);
			else
				break;
		}
		
		return buf.reverse().join("");
	},

	name : "env",
	identifierRegexps : [ /[a-zA-Z_0-9\$\-\u00A2-\uFFFF\.]/ ],
	getCompletions : function(editor, session, pos, prefix, callback) {
		completions = [ 
                        {name:"env.uic", value:"env.uic", score:9000, meta:"用户中心"},
                        {name:"env.uic.fuzzyUser", value:"env.uic.fuzzyUser(userNick)", score:800, meta:"混淆用户名"},
                        {name:"env.uic.getUser", value:"env.uic.getUser(userId)", score:900, meta:"跟据用户id获取用户数据"},
                        {name:"env.uic.getUserByNick", value:"env.uic.getUserByNick(usernick)", score:900, meta:"跟据用户名获取用户数据"},
                        
                        {name:"env.ic", value:"env.ic", score:9000, meta:"商品中心"},
                        {name:"env.ic.getItem", value:"env.ic.getItem(itemId)", score:900, meta:"获取商品详情"},
                        {name:"env.forestService", value:"env.forestService", score:9000, meta:"类目系统"},
                        {name:"env.forestService.getCategoryDO", value:"env.forestService.getCategoryDO(catagoryId)", score:900, meta:"获取类目信息"},
                        {name:"env.forestService.isChild", value:"env.forestService.isChild(CategoryDO,catagoryId)", score:900, meta:"判断类目归属"},
                        {name:"env.notifySender", value:"env.notifySender", score:9000, meta:"Notify消息发送"},
                        {name:"env.notifyReceiver", value:"env.notifyReceiver", score:9000, meta:"Notify消息接受初始化"},
                        {name:"env.log", value:"env.log('log')", score:9010, meta:"可观察Log"},
                        {name:"env.bi", value:"env.bi('attr','value')", score:9010, meta:"BI统计用kv值"},
                        {name:"env.counter", value:"env.counter", score:9009, meta:"监控面板统计用kv值"},  
                        {name:"env.counter.lazyAdd", value:"env.counter.lazyAdd(key, count, ValidMode )", score:900, meta:"1s延时统计PV"},                        
                        {name:"env.counter.lazyAddOnce", value:"env.counter.lazyAddOnce(key, uniqToken,count, ValidMode)", score:900, meta:"1s延时统计UV"},
 
		];
		var fullPrefix = this.findPrefix(session, pos);
		callback(null, completions.filter(function(e) {
			return e.name.startsWith(fullPrefix);
		}).map(
				function(m) {
					// 剩余待补充内容
					var remain = m.value.substring(fullPrefix.length
							- prefix.length, m.value.length);
					m.snippet = remain;
					return m;
				}));
		console.log("finish");
	}
}

$(document).ready(function() {
	var langTools = ace.require("ace/ext/language_tools");
	function initAce(aceEditor) {
		var innereditor = ace.edit(aceEditor);
		innereditor.setOptions({
			enableBasicAutocompletion : true,
			enableSnippets : true,
			enableLiveAutocompletion : true
		});
		innereditor.getSession().on('change', function(e) {
			localStorage[getLocalKey(aceEditor)] = innereditor.getValue();
			localStorage[getLocalKey("resume")] = true;
			return true;
		});

		return innereditor;
	}
	var editor = initAce("editor");

	langTools.addCompleter(envCompleter);
});
