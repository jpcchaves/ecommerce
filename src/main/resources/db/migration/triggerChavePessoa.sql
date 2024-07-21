create or replace function validaChavePessoa()
    returns trigger
    language plpgsql
as $$
declare existe integer;

begin
    existe = (select count(1) from pessoa_fisica where id = new.pessoa_id);

    if(existe <= 0) then

        existe = (select count(1) from pessoa_juridica where id = new.pessoa_id);

        if(existe <= 0) then
            raise exception 'Nao foi encontrado o ID ou PK da pessoa para realizar a associacao!';

        end if;
    end if;
    return new;
end;
$$


create or replace function validaChavePessoaForn()
    returns trigger
    language plpgsql
as $$
declare existe integer;

begin
    existe = (select count(1) from pessoa_fisica where id = new.pessoa_forn_id);

    if(existe <= 0) then

        existe = (select count(1) from pessoa_juridica where id = new.pessoa_forn_id);

        if(existe <= 0) then
            raise exception 'Nao foi encontrado o ID ou PK da pessoa para realizar a associacao!';

        end if;
    end if;

    return new;
end;
$$

create trigger validaChavePessoa
    before update or insert
    on avaliacao_produto
    for each row
execute procedure validaChavePessoa();

create trigger validaChavePessoa
    before update or insert
    on conta_pagar
    for each row
execute procedure validaChavePessoa();

create trigger validaChavePessoaForn
    before update or insert
    on conta_pagar
    for each row
execute procedure validaChavePessoaForn();

create trigger validaChavePessoa
    before update or insert
    on conta_receber
    for each row
execute procedure validaChavePessoa();

create trigger validaChavePessoa
    before update or insert
    on endereco
    for each row
execute procedure validaChavePessoa();

create trigger validaChavePessoa
    before update or insert
    on nota_fiscal_compra
    for each row
execute procedure validaChavePessoa();

create trigger validaChavePessoa
    before update or insert
    on nota_item_produto
    for each row
execute procedure validaChavePessoa();

create trigger validaChavePessoa
    before update or insert
    on usuario
    for each row
execute procedure validaChavePessoa();

create trigger validaChavePessoa
    before update or insert
    on venda_compra_loja_virtual
    for each row
execute procedure validaChavePessoa();
