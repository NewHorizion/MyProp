function calculateArea()
{
	var unitFactors = { 'Sq-ft': 1, 
						'Sq-m': 0.0930000000000000000, 
						'Sq-yrd': 0.1111111111111000000,
						'Acre' : 0.0000229566300000000,
						'Hectare' : 0.0000092904166000000,
						'Bigha1' : 0.0000573921030000000,
						'Bigha2' : 0.000036730946000000,
						'Biswa1' : 0.000002869605100000,
						'Biswa2' : 0.000001836547300000,
						'Kottah' : 0.00138888890000000,
						'Kanal' : 0.00000926059690000,
						'Marla' : 0.00018521194000000,
						'Ground' : 0.00041666667000000,
						'Cents' : 0.00229600000000000,
						'Aankadam' : 0.01389088900000000,
						'Perch' : 0.00367242010000000,
						'Rood' : 0.00009181050300000,
						'Guntha' : 0.00091827364554640,
						'Chatak' : 0.002222222222222223,
						'Ares' : 0.00092936802973000,
					};
	var firstvalue =0;
	var areaValue = document.getElementById("areaValue").value;
	var areaUnit = document.getElementById("areaUnit");
	var selectedUnit = areaUnit.options[areaUnit.selectedIndex].value;
	var expectedAreaUnit = document.getElementById("expectedAreaUnit");
	var selectedExpectedUnit = expectedAreaUnit.options[expectedAreaUnit.selectedIndex].value;
	var areaFactor = unitFactors[selectedUnit];
	var expectedAreaFactor = unitFactors[selectedExpectedUnit];
	firstValue=areaValue/areaFactor;
		
	var expectedAreaValue = firstValue*expectedAreaFactor;
	document.getElementById("areaValue1").value = expectedAreaValue;
}