 	  document.onmousedown = function(event){
        var e = event || window.event||arguments.callee.caller.arguments[0];
        var elem = e.srcElement||e.target;

                while(elem)
                {
                    if(elem.id==='calendershow')
                    {
                            return;
                    }
                    elem = elem.parentNode;
                }
        if(e.button==0 || e.button==1){


	   if (document.getElementById("calendershow")) {
			document.getElementById("calendershow").style.display = "none";
		}
        }
    }

Date.prototype.format= function(fmt){
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

var topview;


$(document).ready(function () {
	 var domain=document.getElementById('chosen').innerHTML;
     var domain1=domain.replace(/(\s*$)/g, "");
	var domain2=domain1.split(' ');
	var domain3=domain2[domain2.length-1];
    init(domain3);
	//setInterval('update()',10000);
})




function init(domain2)
{
	var domainid="";
	var name="";
	get_app_list_online_domain(domain2,function(result,data){
		domainid=data.data[0].domainId;

		get_appname_by_id(domainid,'0',function(result,data){
			name=data.appname;

			if(domainid==''||name==''){
				return;
			}else{
		   topview = new TTopBoardViewModel(domain2,domainid,name);
		    ko.applyBindings(topview, $("#administration")[0]);
			}
		});

	});
}


function domain_name(name,id,domian,company,domian_name){
	// if(str=="-----------------------Top10-----------------------"||str=="-----------------------全部-----------------------"){
	// 		return;
	// 	  }
	// 	else{
	// var str=str.split(')');
	// topview.select_domain_name(str[1]);
	// 	}
  topview.change_app(name,id,domian,company,domian_name);
}

/*
function update(){
	topview.get_user_speed();
	var data=document.getElementById('percent').innerHTML;
	$('#easypiechart').data('easyPieChart').update(data);
	topview.get_count_speed();
	var data1=document.getElementById('percent1').innerHTML;
	$('#easypiechart1').data('easyPieChart').update(data1);
	topview.get_time_speed();
	var data2=document.getElementById('percent2').innerHTML;
	$('#easypiechart2').data('easyPieChart').update(data2);
}
*/

function TTopBoardViewModel(domain,id,name) {
    var self = this;
	self.select_domain=ko.observable(domain);
	self.select_domainId=ko.observable('9999');
    self.all_domain_list=ko.observableArray();
	self.all_normal_domain_list=ko.observableArray();
    self.all_app_list=ko.observableArray();
	self.select_app=ko.observable(name);
    self.app_id=ko.observable('0');
    self.company = ko.observable('JUPHOON');
    self.domain_name = ko.observable('justalk.com');
    self.email = ko.observable('dev@justalk.com');

	self.total_new_total = ko.observable('0');
	self.total_count_total = ko.observable('0');
	self.total_time_total = ko.observable('0');

	//self.today_new_total = ko.observable('0');
	//self.today_count_total = ko.observable('0');
	//self.today_time_total = ko.observable('0');


	self.total_zllv = ko.observable('0.00%');
	self.total_hjlv = ko.observable('0.00%');
	//self.today_zllv = ko.observable('0.00%');
	//self.today_hjlv = ko.observable('0.00%');

	//self.today_date = ko.observable(new Date().format("yyyy/MM/dd"));
	//self.today_array = ko.observableArray();
	//self.yester_date = ko.observable(new Date(new Date().setTime(new Date().getTime() - 24 * 3600 * 1000)).format("yyyy/MM/dd"));
	//self.yester_array = ko.observableArray();
	//self.today_count_array = ko.observableArray();
	//self.yester_count_array = ko.observableArray();
	//self.today_time_array = ko.observableArray();
	//self.yester_time_array = ko.observableArray();
	//self.today_zl_array = ko.observableArray();
	//self.yester_zl_array = ko.observableArray();
	//self.today_jt_array = ko.observableArray();
	//self.yester_jt_array = ko.observableArray();

	//self.today_user_growth = ko.observable(0);
	//self.today_count_growth = ko.observable(0);
	//self.today_time_growth = ko.observable(0);


	//self.now_new_user = ko.observable();
	//self.now_talk_count = ko.observable();
	//self.now_talk_time = ko.observable();
    
    self.today_title = ko.observable('-1');
    self.today_title_d = ko.observable([true,true,true,true,true,true]);
    
    self.call_date_range_show = ko.observable(false);
	self.call_date_list = ko.observable(false);
    self.call_count_date_out_show = ko.observable(false);
    self.call_date_range = ko.observable('过去30天');
    self.call_date_ranges = ko.observable(['全部','过去7天','过去30天','自定义']);
    self.call_date_range_index = ko.observable(2);
    self.call_count_settime = ko.observable(30);
    self.call_count_custom_endtime = ko.observable(new Date(new Date().setTime(new Date().getTime()-24*3600*1000)).format("yyyy-MM-dd"));//自定义结束时间,默认昨天
    self.call_count_custom_statrtime = ko.observable(new Date(new Date().setTime(new Date().getTime()-30*24*3600*1000)).format("yyyy-MM-dd"));//自定义开始时间,默认前30天
    self.call_count_timesection = ko.observable();

	self.allcount=ko.observable(0);
	self.timetype = ko.observable('day');
    
    self.call_type = ko.observable('');
    self.shichang = ko.observableArray();
    
    self.domain_time_loaded = ko.observable(true);

    self.dddd = ko.observable('');
    
  var date = new Date();

 

  self.click_test = function(){
    $("#s2id_select2-option").click();
  }
  
  self.getPic = function(){
	  self.callstatrtime(start);
	  self.callendtime(end);
	  self.getPifcFrom();
  };
  
  self.date_range_pick_init = function(){
	$('.custom-date').dateRangePicker(self.getPic);
  }
  
  self.test = function(start, end){
	self.call_count_custom_statrtime(start);
  	self.call_count_custom_endtime(end);
  	self.main_view();
  }
  
  self.date_range_pick_init = function(){
	$('.custom-date').dateRangePicker(self.test);
  }
  
  /*生成图表*/
	self.stat_pic_call_count_all = function(id, series, categories, title, type, allcount) {
		$(id).show();
		$(id).highcharts({
			chart: {
				events: {
					click: function(event) {
						// self.call_date_range_show(false);//日期控件显示
						// self.call_count_date_out_show(false);//下拉区块显示
					}
				}
			},
			plotOptions: {
				enable: true
			},
			title: {
				text: title,
				y: 20
			},
			subtitle: {
			    text: type+" "+allcount
			},
			exporting: {
				enabled: false
			},
			xAxis: {
				categories: categories,
				dateTimeLabelFormats: {
					second: '%H:%M:%S',
					minute: '%H:%M',
					hour: '%H:%M',
					day: '%e. %b',
					week: '%e. %b',
					month: '%b \'%y',
					year: '%Y'
				},
				labels: {
					formatter: function() {
						var x = 0
						return function() {
							var len = categories.length
							x++
							if (len > 10) {
								if (x == (1 + len) || x == (len + len) || x % 3 == 0) {
									if (x == (2 + len) || x == (len + len - 1)) {
										return ''
									} else {
										return this.value
									}
								} else {
									return ''
								}
							} else {
								return this.value
							}
						}
					}()
				}
			},

			yAxis: {
				title: {
					text: null,
				},
				plotLines: [{
					value: 0,
					width: 1,
					color: '#808080'
				}]
			},
			point: {
				pointStart: 0.000001
			},
			tooltip: {
				valueSuffix: '', //%
				crosshairs: true
			},
			plotOptions: {

				line: {
					dataLabels: {
						enabled: true
					},

				}

			},
			series: series,
			credits: {
				enabled: false,
			}
		});

	}




	//时间转换
	self.time_change = function(tag) {
		hour = Math.floor((tag) / 3600);
		minute = Math.floor((tag - 3600 * hour) / 60);
		second = tag - hour * 3600 - minute * 60;
		time = second + '"';
		if (minute >= 0) {
			time = minute + "' " + time;
		}
		if (hour > 0) {
			time = hour + "h " + time;
		}
		return time;
	}
    
     self.change_data = function (tdy){
        if(tdy == '-1'){
            //新增用户(全部)
			data_reg_user(self.call_count_custom_statrtime(), self.call_count_custom_endtime(), self.timetype(), self.select_domainId(), function(result, data) {
				if (data.result == 'ok') {
					data['series'].splice(1,1);
					var sum = 0;
					for (var i = 0; i < data['series'][0].data.length; i++) {
						sum += data['series'][0].data[i];
					}
					data['series'][0].name = "新增用户数";
					self.stat_pic_call_count_all('#day_user_hour_static', data['series'], data['categories'],'','','')
				}

			})
        }
        else{
            self.today_title_d()[self.today_title()]=true;
            self.today_title(tdy);
            self.today_title_d()[self.today_title()]=false;
            if(tdy == '0'){
                //#day_user_hour_static
                //新增用户(全部)
            	data_reg_user(self.call_count_custom_statrtime(), self.call_count_custom_endtime(), self.timetype(), self.select_domainId(), function(result, data) {
    				if (data.result == 'ok') {
    					data['series'].splice(1,1);
    					var sum = 0;
    					for (var i = 0; i < data['series'][0].data.length; i++) {
    						sum += data['series'][0].data[i];
    					}
    					self.allcount(parseFloat(sum).toLocaleString());
    					data['series'][0].name = "新增用户数";
    					self.stat_pic_call_count_all('#day_user_hour_static', data['series'], data['categories'],'','','')
    				}
    
    			})
            }   
            else if(tdy == '1'){
               //累计用户
            	data_reg_all_user(self.call_count_custom_statrtime(), self.call_count_custom_endtime(), self.timetype(), self.select_domainId(), function(result, data) {
    				if (data.result == 'ok') {
    					data['series'].splice(1,1);
    					var sum = 0;
    					for (var i = 0; i < data['series'][0].data.length; i++) {
    						sum += data['series'][0].data[i];
    					}
    					self.allcount(parseFloat(sum).toLocaleString());
    					data['series'][0].name = "累计用户数";
    					self.stat_pic_call_count_all('#day_user_hour_static', data['series'], data['categories'],'','','')
    				}
    
    			})
            } 
            else if(tdy=='2'){
                get_call_number(self.call_count_custom_statrtime(), self.call_count_custom_endtime(), self.call_type(), self.app_id(), self.timetype(), self.select_domainId(), function(result, data) {
        			if (data.result == 'ok') {
        				data['series'].splice(1,1);
        				var sum = 0;
        				for (var i = 0; i < data['series'][0].data.length; i++) {
        					sum += data['series'][0].data[i];
        				}
        				self.allcount(parseFloat(sum).toLocaleString());
        				data['series'][0].name = "次数统计";
        
        				//写入通话时长统计表
        				self.stat_pic_call_count_all('#day_user_hour_static', data['series'], data['categories'],'','','')
        			}
        		})
            }
            else if(tdy=='3'){
                get_call_time(self.call_count_custom_statrtime(), self.call_count_custom_endtime(), self.call_type(), self.app_id(), self.timetype(), self.select_domainId(), function(result, data) {
        			if (data.result == 'ok') {
        				var sum = 0;
        				self.shichang().length = 0;
        				for (var i = 0; i < data['series'][0].data.length; i++) {
        					sum += data['series'][0].data[i];
        					self.shichang.push(Math.ceil(data['series'][0].data[i] / 60));
        				}
        				self.allcount(parseFloat(sum).toLocaleString());
        				data['series'][0].name = "时长统计";
        
        				//写入通话时长统计表
        				self.stat_pic_call_count_all('#day_user_hour_static', [{
        					name: data['series'][0].name,
        					data: self.shichang()
        				}], data['categories'],'','','');
        			}
        		})
            }
            else if(tdy=='4'){
        	  zt_get_all_zl(self.call_count_custom_statrtime(), self.call_count_custom_endtime(), self.select_domainId(), self.app_id(), function(result, data) {
    				if (data.result == 'ok') {
			    
    					data['series'][0].name = "整体振铃率";
    					self.stat_pic_call_count_all('#day_user_hour_static', [{
        					name: data['series'][0].name,
        					data: data['series'][0].data
        				}], data['categories'],'','','')
    				}
    
    			})
            }
            else if(tdy=='5'){
        	  zt_get_all_jt(self.call_count_custom_statrtime(), self.call_count_custom_endtime(), self.select_domainId(), self.app_id(), function(result, data) {
    				if (data.result == 'ok') {
			    
    					data['series'][0].name = "整体接通率";
    					self.stat_pic_call_count_all('#day_user_hour_static', [{
        					name: data['series'][0].name,
        					data: data['series'][0].data
        				}], data['categories'],'','','')
    				}
    
    			})
            }
        }
    }



	/*取得总注册用户数*/
	self.get_all_reg_users = function() {
		data_reg_user_all(self.select_domainId(), function(result, data) {
			console.log(data);
			if (data.result == 'ok') {
				if (data.total == null) {
					self.total_new_total('0');
				} else {
					self.total_new_total(parseFloat(data.total).toLocaleString());
				}

			}
		})

	}

	/*取得总通话次数*/
	self.get_all_talk_count = function() {
		data_call_num_all(self.select_domainId(), self.app_id(), function(result, data) {
			console.log(data);
			if (data.result == 'ok') {
				if (data.total == null) {
					self.total_count_total('0');
				} else {
					self.total_count_total(parseFloat(data.total).toLocaleString());
				}
			}

		})
	}

		/*取得总通话时长*/
	self.get_all_talk_time = function() {
		data_call_time_all(self.select_domainId(), self.app_id(), function(result, data) {
			console.log(data);
			if (data.result == 'ok') {
				if (self.total = null) {
					self.total_time_total('0');
				} else {
					self.total_time_total(data.total);
				}
			}
		});
	}

	/*取得总振铃率和呼叫成功率*/
	self.get_all_lv = function() {
		jt_zl_by_all(self.select_domainId(), self.app_id(), function(result, data) {
			console.log(data);
			if (data.result == 'ok') {
				self.total_zllv(data.zl_all);
				self.total_hjlv(data.jt_all);

			}
		});
    }
	


	//主函数
	self.main_view = function(){
    	self.get_all_reg_users();
    	self.get_all_talk_count();
    	self.get_all_talk_time();
    
    	self.get_all_lv();
        
        self.change_data(self.today_title());
	}



		//得到applist
	 self.get_app_list=function(){
		get_app_list_online(self.select_domainId(),function(result,data){
		    console.log(data);
	         if(data.result=='ok'){
				 self.all_app_list(data.data);

		    }
		});

	 }

	 //根据appid得到app名
	self.get_appname=function(){
		get_appname_by_id(self.select_domainId(),self.app_id(),function(result,data){
			console.log(data);
			if (data.result == 'ok') {
				self.select_app(data.appname);
			}
		})
	}


	//写入cookie
	self.setcookie=function(strurl,strpost){
		var xmlHttp
		//接收表单的URL地址
		var url="./"+strurl;
		//浏览器兼容识别

		var ajax = false;
		//开始初始化XMLHttpRequest对象
		if(window.XMLHttpRequest) { //Mozilla 浏览器
			ajax = new XMLHttpRequest();
			if (ajax.overrideMimeType) {//设置MiME类别
				ajax.overrideMimeType("text/xml");
			}
		}
		else if (window.ActiveXObject) { // IE浏览器
			try {
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					ajax = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {}
			}
		}
		if (!ajax) { // 异常，创建对象实例失败
			window.alert("不能创建XMLHttpRequest对象实例.");
			return false;
		}
		//通过Post方式打开连接
		ajax.open("POST",url,true);

		//定义传输的文件HTTP头信息
		ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//发送POST数据
		ajax.send(strpost);

		//获取执行状态
		ajax.onreadystatechange = function() {
			//如果执行状态成功，那么就把返回信息写到指定的层里
			if (ajax.readyState == 4 && ajax.status == 200) {
				//alert(strpost);
			}
		}
	}


		//选择域
	  self.select_domain_name = function(index){
            self.select_domain(index);
			var strurl="./setcookie.php";
			var strpost="domainname="+self.select_domain();
			self.setcookie(strurl,strpost);

			get_app_list_online_domain(self.select_domain(),function(result,data){
					if(data.result=='ok'){
					self.select_domainId(data.data[0].domainId);
                    self.get_app_list();
					 if(data.data.length==0){
					$('#list2').removeClass('open');
				     }else{
					self.app_id('0');
		            self.get_appname();
				    self.main_view();
					 }
			}
	});
    }

    self.change_app = function(name,id,domain,company,domian_name){
      self.company(company);
      self.domain_name(domian_name);
      domain = domain.replace(/\s/g,"");
      self.select_app(name);
  		self.app_id(id);
      for (var i = 0; i < self.all_normal_domain_list().length; i++) {
        if (self.all_normal_domain_list()[i].domain_text==domain) {
          self.select_domainId(self.all_normal_domain_list()[i].domainId);
          self.email(self.all_normal_domain_list()[i].email)
        }
      }
  		self.main_view();
    }

	 //选择app
    self.select_app_name=function(index){
		self.select_app(self.all_app_list()[index].appName);
		self.app_id(self.all_app_list()[index].appId);
		$('#list2').removeClass('open');
		self.main_view();
	}



		//得到常用域名
	   get_domain_rank('10',function(result,data){
       for (var i = 0; i < data.data.domain.length; i++) {
         str = "";
         data.data.domain[i].domain_total = data.data.domain[i].domain_total.replace(/\s/g,"");
         data.data.domain[i].domain_text = data.data.domain[i].domain_total.substring(data.data.domain[i].domain_total.indexOf('(')+1,data.data.domain[i].domain_total.indexOf(')'))+data.data.domain[i].domain_total.substring(data.data.domain[i].domain_total.indexOf(')')+1,data.data.domain[i].domain_total.length);
         for (var j = 0; j <  data.data.app.length; j++) {
           if (data.data.domain[i].domainId==data.data.app[j].domainId) {
             str += "<option value="+data.data.app[j].app_id+">"+data.data.app[j].app_name+"</option>";
           }
         }
         $("#select2-option").append("<optgroup label="+data.data.domain[i].domain_total+">"+str+"</optgroup>");
       }
       $("#chosen").html('justalk');
		console.log(data);
		self.all_normal_domain_list(data.data.domain);

	    })
	    
 self.dateRangePicker = $('.custom-date').dateRangePicker(self.test);//传递self.test给时间，好进行回调
        
	self.main_view();
	self.get_app_list();
    self.date_range_pick_init(); 
}
