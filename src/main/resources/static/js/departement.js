/**
 * Created by derteuffel on 31/12/2018.
 */
let departementSelect= $("#sel1");
departementSelect.change(()=>{
    if(departementSelect.val()== "Informatique et télécommunications"){
$("#code").val("INFOTEL");
}else if (departementSelect.val()=="Hydrauliqque et maitrise des eaux"){
    $("#code").val("HYMAE");
}else if(departementSelect.val()=="Genie civil et architecture"){
    $("#code").val("GCA");
}else if(departementSelect.val()=="Agriculture, élévage et produit derrivé"){
    $("#code").val("AGEPD");
}else if(departementSelect.val()=="Sciences environementales"){
    $("#code").val("SCIENVI");
}else if(departementSelect.val()=="Genie du textile et du cuir"){
    $("#code").val("GTC");
}
})