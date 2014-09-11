scotchApp
	.controller('FloorNoList', function($scope) {
	  $scope.floorNos = [
	    { id: '1001', value:'1'},
	    { id: '1002', value:'2'},
	    { id: '1003', value:'3'},
	    { id: '1004', value:'4'},
	    { id: '1005', value:'5'},
	    { id: '1006', value:'6'},
	    { id: '1007', value:'7'},
	    { id: '1008', value:'8'},
	    { id: '1009', value:'9'},
	    { id: '1010', value:'10'},
	    { id: '1011', value:'11'},
	    { id: '1012', value:'12'},
	    { id: '1013', value:'13'},
	    { id: '1014', value:'14'},
	    { id: '1015', value:'15'},
	    { id: '1016', value:'16'},
	    { id: '1017', value:'17'},
	    { id: '1018', value:'18'},
	    { id: '1019', value:'19'},
	    { id: '1020', value:'20'},
	    { id: '1021', value:'21'},
	    { id: '1022', value:'22'},
	    { id: '1023', value:'23'},
	    { id: '1024', value:'24'},
	    { id: '1025', value:'25'},
	    { id: '1026', value:'26'},
	    { id: '1027', value:'27'},
	    { id: '1028', value:'28'},
	    { id: '1029', value:'29'},
	    { id: '1030', value:'30'},
	    { id: '1031', value:'31'},
	    { id: '1032', value:'32'},
	    { id: '1033', value:'33'},
	    { id: '1034', value:'34'},
	    { id: '1035', value:'35'},
	    { id: '1036', value:'36'},
	    { id: '1037', value:'37'},
	    { id: '1038', value:'38'},
	    { id: '1039', value:'39'},
	    { id: '1040', value:'40'},
	    { id: '1041', value:'41'},
	    { id: '1042', value:'42'},
	    { id: '1043', value:'43'},
	    { id: '1044', value:'44'},
	    { id: '1045', value:'45'},
	    { id: '1046', value:'46'},
	    { id: '1047', value:'47'},
	    { id: '1048', value:'48'},
	    { id: '1049', value:'49'},
	    { id: '1050', value:'50'},
	    { id: '1051', value:'51'},
	    { id: '1052', value:'52'},
	    { id: '1053', value:'53'},
	    { id: '1054', value:'54'},
	    { id: '1055', value:'55'},
	    { id: '1056', value:'56'},
	    { id: '1057', value:'57'},
	    { id: '1058', value:'58'},
	    { id: '1059', value:'59'},
	    { id: '1060', value:'60'},
	    { id: '1061', value:'61'},
	    { id: '1062', value:'62'},
	    { id: '1063', value:'63'},
	    { id: '1064', value:'64'},
	    { id: '1065', value:'65'},
	    { id: '1066', value:'66'},
	    { id: '1067', value:'67'},
	    { id: '1068', value:'68'},
	    { id: '1069', value:'69'},
	    { id: '1070', value:'70'},    
	    { id: '1071', value:'71'},
	    { id: '1072', value:'72'},
	    { id: '1073', value:'73'},
	    { id: '1074', value:'74'},
	    { id: '1075', value:'75'},
	    { id: '1076', value:'76'},
	    { id: '1077', value:'77'},
	    { id: '1078', value:'78'},
	    { id: '1079', value:'79'},
	    { id: '1080', value:'80'},
	    { id: '1081', value:'81'},
	    { id: '1082', value:'82'},
	    { id: '1083', value:'83'},
	    { id: '1084', value:'84'},
	    { id: '1085', value:'85'},
	    { id: '1086', value:'86'},
	    { id: '1087', value:'87'},
	    { id: '1088', value:'88'},
	    { id: '1089', value:'89'},
	    { id: '1090', value:'80'},
	    { id: '1091', value:'91'},
	    { id: '1092', value:'92'},
	    { id: '1093', value:'93'},
	    { id: '1094', value:'94'},
	    { id: '1095', value:'95'},
	    { id: '1096', value:'96'},
	    { id: '1097', value:'97'},
	    { id: '1098', value:'98'},
	    { id: '1099', value:'99'},
	    { id: '1100', value:'100'},
	    { id: '1101', value:'101'},
	    { id: '1102', value:'102'},
	    { id: '1103', value:'103'},
	    { id: '1104', value:'104'},
	    { id: '1105', value:'105'},
	    { id: '1106', value:'106'},
	    { id: '1107', value:'107'},
	    { id: '1108', value:'108'},
	    { id: '1109', value:'109'},
	    { id: '1110', value:'110'},
	    { id: '1111', value:'111'},
	    { id: '1112', value:'112'},
	    { id: '1113', value:'113'},
	    { id: '1114', value:'114'},
	    { id: '1115', value:'115'},
	    { id: '1116', value:'116'},
	    { id: '1117', value:'117'},
	    { id: '1118', value:'118'},
	    { id: '1119', value:'119'},
	    { id: '1120', value:'120'},
	    { id: '1121', value:'121'},
	    { id: '1122', value:'122'},
	    { id: '1123', value:'123'},
	    { id: '1124', value:'124'},
	    { id: '1125', value:'125'},
	    { id: '1126', value:'126'},
	    { id: '1127', value:'127'},
	    { id: '1128', value:'128'},
	    { id: '1129', value:'129'},
	    { id: '1130', value:'130'},
	    { id: '1131', value:'131'},
	    { id: '1132', value:'132'},
	    { id: '1133', value:'133'},
	    { id: '1134', value:'134'},
	    { id: '1135', value:'135'},
	    { id: '1136', value:'136'},
	    { id: '1137', value:'137'},
	    { id: '1138', value:'138'},
	    { id: '1139', value:'139'},
	    { id: '1140', value:'140'},
	    { id: '1141', value:'141'},
	    { id: '1142', value:'142'},
	    { id: '1143', value:'143'},
	    { id: '1144', value:'144'},
	    { id: '1145', value:'145'},
	    { id: '1146', value:'146'},
	    { id: '1147', value:'147'},
	    { id: '1148', value:'148'},
	    { id: '1149', value:'149'},
	    { id: '1150', value:'150'},
	  ];
	}).directive('floorNoCtrl', function() {
		return {
			restrict: 'E',
			templateUrl : 'pages/floor-no-ctrl.html'
		};
	}).directive('totalFloorCtrl', function() {
		return {
			restrict: 'E',
			templateUrl : 'pages/total-floor-ctrl.html'
		}; 
	});


scotchApp
.controller('BedBathNoList', function($scope) {
  $scope.roomNos = [
    { id: '1001', label:'1', ticked: false},
    { id: '1002', label:'2', ticked: false},
    { id: '1003', label:'3', ticked: false},
    { id: '1004', label:'4', ticked: false},
    { id: '1005', label:'5', ticked: false},
    { id: '1006', label:'6', ticked: false},
    { id: '1007', label:'7', ticked: false},
    { id: '1008', label:'8', ticked: false},
    { id: '1009', label:'9', ticked: false},
    { id: '1010', label:'10', ticked: false},
    { id: '1011', label:'>10', ticked: false}
  ];
}).directive('bedroomNoCtrl', function() {
	return {
		restrict: 'E',
		templateUrl : 'pages/bedroom-no-ctrl.html'
	};
}).directive('bathroomNoCtrl', function() {
	return {
		restrict: 'E',
		templateUrl : 'pages/bathroom-no-ctrl.html'
	}; 
}).directive('balconyNoCtrl', function() {
	return {
		restrict: 'E',
		templateUrl : 'pages/balcony-no-ctrl.html'
	}; 
});


scotchApp
	.controller('AreaUnits', function($scope) {
		$scope.areaUnits = [
		     { id: 'Sq-yrd', value:'Sq-yrd'},
		     { id: 'Sq-m', value:'Sq-m'},
		     { id: 'Acre', value:'Acre'},
		     { id: 'Bigha', value:'Bigha'},
		     { id: 'Hectare', value:'Hectare'},
		     { id: 'Marla', value:'Marla'},
		     { id: 'Kanal', value:'Kanal'},
		     { id: 'Biswa1', value:'Biswa1'},
		     { id: 'Biswa2', value:'Biswa2'},
		     { id: 'Ground', value:'Ground'},
		     { id: 'Aankadam', value:'Aankadam'},
		     { id: 'Rood', value:'Rood'},
		     { id: 'Chatak', value:'Chatak'},
		     { id: 'Kottah', value:'Kottah'},
		     { id: 'Ground', value:'Ground'},
		     { id: 'Cents', value:'Cents'},
		     { id: 'Perch', value:'Perch'},
		     { id: 'Guntha', value:'Guntha'},
		     { id: 'Ares', value:'Ares'}
		];
});

scotchApp
	.controller('InHouseAmenityCtrl', function($scope) {
	  $scope.inHouseAmenities = [
	          {id:1, label: 'Servant Quarters', ticked: false}, 
	          {id:2, label: 'Private Terrace/ Garden', ticked: false}, 
	          {id:3, label: 'Vaastu Compliant', ticked: false}, 
	          {id:4, label: 'Air Conditioned', ticked: false},	          
	          {id:5, label: 'Intercom Facility', ticked: false}, 
	          {id:6, label: 'Internet / Wi-Fi Connectivity', ticked:false}, 
	          {id:7, label: 'RO Water System', ticked: false}, 
	          {id:8, label: 'Piped Gas', ticked: false}
	    ];
	  $scope.itemSelect = function(data) {
		  
	  };
});

scotchApp
.controller('ExtAmenityCtrl', function($scope) {
  $scope.extAmenities = [
          {id:1, label: 'Power Back Up'}, 
          {id:2, label: 'Lift'}, 
          {id:3, label: 'Rain Water Harvesting'}, 
          {id:4, label: 'Club House'},	          
          {id:5, label: 'Swimming pool'}, 
          {id:6, label: 'Gymnasium'}, 
          {id:7, label: 'Park'}, 
          {id:8, label: 'Reserved parking'},
          {id:9, label: 'Security'},
          {id:10, label: 'Water Storage'},	          
          {id:11, label: 'Service/Goods Lift'}, 
          {id:12, label: 'Visitor parking'}, 
          {id:13, label: 'Maintenance Staff'}, 
          {id:14, label: 'Waste Disposal'},          
          {id:15, label: 'Laundry Service'},
          {id:16, label: 'DTH Television Facility'},
          {id:17, label: 'Banquet Hall'},	          
          {id:18, label: 'Bar/Lounge'}, 
          {id:19, label: 'Cafeteria/Food Court'}, 
          {id:20, label: 'Conference Room'}
    ];
  $scope.checkAll = function() {
	      $scope.extAmenities = angular.copy($scope.extAmenities);
  };
  $scope.uncheckAll = function() {
	      $scope.extAmenities = [];
  };
});

scotchApp
.controller('FurnishedStatuses', function($scope) {
  $scope.furnishedStatuses = [
          {id:1, value: 'Furnished'}, 
          {id:2, value: 'Unfurnished'}, 
          {id:3, value: 'Semi-Furnished'}
    ]; 
});