<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-dark border-bottom border-info border-5" style="background-color: #919cc2;">
    <a class="align-self-center navbar-brand" href="#">
        <i class="fas fa-home fa-1x"></i>
    </a>
    <a class="navbar-brand" href="/">IMTIE</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">


                 <div class="btn-group" role="group" aria-label="Basic outlined example">

                     <#if user??>
                         <a type="button"  href="/main" class="btn btn-outline-light">Товари</a>
                         <a type="button" href="/user/profile" class="btn btn-outline-light">Профіль</a>
                         <a type="button" href="/basket/${currentUserId}" class="btn btn-outline-light">Корзина</a>
                     </#if>

                 </div>
                     <#if isAdmin>
                         <div class="btn-group  ml-5" role="group" aria-label="Basic outlined example">
                             <a type="button" href="/user" class="btn btn-outline-light">Користувачі</a>
                             <a type="button" href="/product" class="btn btn-outline-light">Товари</a>
                             <a type="button" href="/basket/all" class="btn btn-outline-light">Замовлення</a>
                             <a type="button" href="/product/add" class="btn btn-outline-light">Додати</a>
                         </div>

                     </#if>
            <#if !user??>
                <a class="navbar-brand text-center d-flex justify-content-center " style="color: #e7eba4;" href="/">Для того щоб побачити каталог товарів потрібно увійти в обліковий запис! </a>
            </#if>
        </ul>


        <span class="badge  bg-warning text-dark navbar-text mr-3"> ${name} </span>

        <#if user??><@l.logout /></#if>
        <#if !user??>
            <a type="button" href="/login" class="btn btn-success border">Увійти</a>
        </#if>
    </div>
</nav>