'use strict';

/**
 * PrintLabelsController
 * @constructor
 */
var PrintLabelsController = ['$scope', '$http', '$window','$cookieStore','$rootScope','SessionService','PrintLabelsControllerPreLoad','$timeout','$sce',function($scope, $http, $window,$cookieStore,$rootScope,SessionService,PrintLabelsControllerPreLoad,$timeout,$sce) {
	
	$rootScope.MainSideBarhideit = false;
	$rootScope.MainHeaderideit = false;
	$scope.products = [];
	$scope.product = {};
	$scope.airportName = [];
	$timeout(function(){
		$scope.printCount =  $scope.printCounting;
		JsBarcode(".barcode").init();
	    }, 1500);
	$scope.productVaraintDetailBeanList = [];
	$scope.sessionValidation = function(){
		for(var index=0; index<40; index++){
			$scope.product = {};
			$scope.product.id=index;
			$scope.products.push($scope.product);
		}
		$rootScope.globalPageLoader = false;
		if(SessionService.validate()){
			$scope._s_tk_com =  $cookieStore.get('_s_tk_com') ;
			$scope.data = PrintLabelsControllerPreLoad.loadControllerData();
			$scope.companyName = $scope.data.companyName;
			$scope.allProducts = $scope.data.productsBean;
			for (var i = 0; i < $scope.allProducts.length; i++) {
				if($scope.allProducts[i].productVariantsBeans){
					for (var j = 0; j < $scope.allProducts[i].productVariantsBeans.length; j++) {
						$scope.productVaraintDetailBeanList.push( $scope.allProducts[i].productVariantsBeans[j]);
					}	
				}
				
				
					
			}
	}
	};
	
	$scope.autoCompleteOptions = {
			minimumChars : 1,
			dropdownHeight : '200px',
			data : function(term) {
				term = term.toLowerCase();
				$scope.productVariantsBeans = [];
				var productVariantResults = _.filter($scope.productVaraintDetailBeanList, function(val) {
					
					
					return val.variantAttributeName.toLowerCase().includes(term) || val.sku.toLowerCase().includes(term.toLowerCase());

					});
				/* productVariantResults = _.filter($scope.productVaraintDetailBeanList, function(val) {
						var skuLowercase =  val.sku.toLowerCase();
						if(skuLowercase == term.toLowerCase()){
							$scope.variantSkuFound =  true;
						}
						
						return skuLowercase == term.toLowerCase();
						
					});
				
				var productResults = _.filter($scope.allProducts, function(val) {
					return val.productName.toLowerCase().includes(term) || val.sku.toLowerCase().includes(term.toLowerCase());

				});*/
				
				var list = [];
				if(false){
					$scope.selectedItem = {};
					$scope.printLabelsFunc(productVariantResults[0]);
					$scope.selectedItem.item = productVariantResults[0];
					list = productResults;
					$scope.variantSkuFound =  false;
					$scope.airportName = [];
					
				}else{
					list = productResults.concat(productVariantResults);
				}
				
			
				
				return list;
			},
			renderItem : function(item) {
				var result = {
						value : item.variantAttributeName,
						label : $sce.trustAsHtml("<table class='auto-complete'>"
								+ "<tbody>" + "<tr>" + "<td style='width: 90%'>"
								+ item.variantAttributeName +' '+ name + "</td>"
								+ "<td style='width: 10%'>"
								+ item.retailPriceExclTax + "</td>" + "</tr>"
								+ "</tbody>" + "</table>")
				};
				return result;
			},
			itemSelected : function(item) {
				$scope.airportName = [];
				$scope.selectedItem ={};
				$scope.selectedItem = item;
				$scope.selectProduct = true;
				$scope.printLabelsFunc( $scope.selectedItem.item);
				
			}
	};
	$scope.fetchData = function() {
		$rootScope.roleDetailsLoadedFully = false;
		if($scope.data == 'NORECORDFOUND'){

			$scope.error = true;
			$scope.errorMessage = "No record found";
		}
		else if($scope.data == 'SYSTEMBUSY'){
			$scope.error = true;
			$scope.errorMessage = $scope.systemBusy;
		}
		else if($scope.data == 'INVALIDSESSION'){
			$scope.error = true;
			$scope.errorMessage = 'An exception occured while validating session !';
			$window.location = '/app/#/login';

		}
		else{
			
		}
	
	};
	String.prototype.replaceAll = function(search, replacement) {
		var target = this;
		return target.replace(new RegExp(search, 'g'), replacement);
	};
	$scope.printCountChange = function(){
		
		$scope.layoutproducts = [];
		var product = $scope.selectedItem.item
		$scope.printCount =  $scope.printCounting;
		
		for(var index=0; index<$scope.printCount; index++){
			$scope.printLabelsProduct = {};
			$scope.printLabelsProduct.sku = product.sku;
			
			$scope.printLabelsProduct.productName = product.productName;
			if(product.variantAttributeName){
				$scope.printLabelsProduct.productName = "" + $scope.printLabelsProduct.productName  +" " + product.variantAttributeName.replaceAll("/","-");
			}
			$scope.printLabelsProduct.price = product.netPrice;
			$scope.printLabelsProduct.id=index;
			$scope.layoutproducts.push($scope.printLabelsProduct);
		}
		$timeout(function(){
			JsBarcode(".barcode").init();
			$scope.printLabels =  false;
			$scope.printCounting = "";
		    }, 1500);
	}
	$scope.layoutproducts = [];
	$scope.layoutproduct = {};
	$scope.printLoading = false;
	$scope.printList = [];
	$scope.printLabelsFunc = function(product){
		
		$scope.printLabelsProduct = {};
		$scope.printLoading = true;
		$scope.printLabelsProduct.sku = product.sku;
		
		$scope.printLabelsProduct.productName = product.productName;
		if(product.variantAttributeName){
			//$scope.printLabelsProduct.productName = "" + $scope.printLabelsProduct.productName  +" " + product.variantAttributeName.replaceAll("/","-");
			var productInfo = product.variantAttributeName.split("/");
			$scope.printLabelsProduct.variantAttributeValue1= productInfo[0];
			$scope.printLabelsProduct.variantAttributeValue2= productInfo[1];
			$scope.printLabelsProduct.productDesc = product.productDesc
		}
		$scope.printLabelsProduct.price = product.netPrice;
//		$rootScope.productId = angular.copy($scope.product.productId);
//		$rootScope.outletId = angular.copy($scope.product.outletId);
//		$window.location = "/app/#/printLabels";
		if(product.varientProducts){
			
		}
		for(var index=0; index<1; index++){
			$scope.layoutproduct = {};
			$scope.layoutproduct.id=index;
			var count = $scope.layoutproducts.length;
			if(count==0){
				$scope.layoutproducts.push($scope.printLabelsProduct);
				$scope.printList.push(product.sku);
			}
			var found  = true;
			for(var indexChild=0; indexChild< count; indexChild++ ){
				if( (!$scope.layoutproducts[indexChild]  || $scope.layoutproducts[indexChild].productName != $scope.printLabelsProduct.productName)  ){
					found  = false;
				}else{
					found  = true;
				}
			}
			
		}
		if(!found){
			$scope.layoutproducts.push($scope.printLabelsProduct);
			$scope.printList.push(product.sku);
		}
		$timeout(function(){
			JsBarcode(".barcode").init();
			$scope.printLabels =  false;
			$scope.printLoading = false;
		    }, 1500);
		
	};
	$scope.printThisElementA4 = "printThisElement";
	$scope.printOptionsA4 = true;
	$scope.changePrinter = function(){
		if($scope.printOptions=="A4"){
			$scope.printOptionsA4 = true;
			$scope.printOptionsContinous = false;
			$scope.printOptionsContinousLarge = false;
			$scope.printOptionsContinousNew = false;
			$scope.printOptionsContinousNewZebra = false;
			$scope.printThisElementA4 = "printThisElement";
			$scope.printThisElementContinous = "";
			$scope.printThisElementContinousLarge = "";
			$scope.printThisElementContinousNew = "";
			$scope.printThisElementContinousNewZebra = "";
		}else if($scope.printOptions=="Continous"){
			$scope.printOptionsA4 = false;
			$scope.printOptionsContinous = true;
			$scope.printOptionsContinousLarge = false;
			$scope.printOptionsContinousNew = false;
			$scope.printOptionsContinousNewZebra = false;
			$scope.printThisElementA4 = "";
			$scope.printThisElementContinous = "printThisElement";
			$scope.printThisElementContinousLarge = "";
			$scope.printThisElementContinousNew = "";
			$scope.printThisElementContinousNewZebra = "";
		}else if($scope.printOptions=="ContinousNew"){
			$scope.printOptionsA4 = false;
			$scope.printOptionsContinous = false;
			$scope.printOptionsContinousLarge = false;
			$scope.printOptionsContinousNew = true;
			$scope.printOptionsContinousNewZebra = false;
			$scope.printThisElementA4 = "";
			$scope.printThisElementContinousNew = "printThisElement";
			$scope.printThisElementContinousLarge = "";
			$scope.printThisElementContinous = "";
			$scope.printThisElementContinousNewZebra = "";
		}else if($scope.printOptions=="ContinousLarge"){
			$scope.printOptionsA4 = false;
			$scope.printOptionsContinous = false;
			$scope.printOptionsContinousLarge = true;
			$scope.printOptionsContinousNew = false;
			$scope.printOptionsContinousNewZebra = false;
			$scope.printThisElementA4 = "";
			$scope.printThisElementContinous = "";
			$scope.printThisElementContinousLarge = "printThisElement";
			$scope.printThisElementContinousNew = "";
			$scope.printThisElementContinousNewZebra = "";
		}else if($scope.printOptions=="ContinousNewZebra"){
			$scope.printOptionsA4 = false;
			$scope.printOptionsContinous = false;
			$scope.printOptionsContinousLarge = false;
			$scope.printOptionsContinousNew = false;
			$scope.printOptionsContinousNewZebra = true;
			$scope.printThisElementA4 = "";
			$scope.printThisElementContinousNew = "";
			$scope.printThisElementContinousLarge = "";
			$scope.printThisElementContinous = "";
			$scope.printThisElementContinousNewZebra = "printThisElement";
		}
		
		
	};
	$scope.sessionValidation();

}];