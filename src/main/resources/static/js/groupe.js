/**
 * Created by derteuffel on 30/12/2018.
 */

$.each(document.getElementsByClassName("user-item"), (i, v) => {
    v.addEventListener("click", () => {
    if (v.getAttribute("style") =="background-color:#2286c3; color:white;")
{
    v.setAttribute("style", "background-color:white; color:black;")
    let arr = $("#usersId").val().split(",")
    console.log(arr);
    if(v.getAttribute("value"))
    {
        let index = arr.indexOf(v.getAttribute("value"));

        if(index>-1)
        {
            arr.splice(index,1);
            console.log(arr.join(","));
            $("#usersId").val(arr.join(","));
        }
    }
    return ;
}
else
{
    v.setAttribute("style","background-color:#2286c3; color:white;")
    if(v.getAttribute("value"))
        $("#usersId").val($("#usersId").val() + ","+ v.getAttribute("value"));
}
})})