PGDMP                         |            ecommerce_db    15.5    15.3 ˆ    Ê
   0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Ë
   0    0
   STDSTRINGS
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            Ì
   0    0
   SEARCHPATH
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            Í
   1262    25861    ecommerce_db    DATABASE     ƒ   CREATE DATABASE ecommerce_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
   DROP DATABASE ecommerce_db;
                postgres    false                        2615    34885    public    SCHEMA        CREATE SCHEMA public;
   DROP SCHEMA public;
                postgres    false            Î
   0    0
   SCHEMA public    ACL     +   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
                   postgres    false    5            Ö            1259    34887    acesso    TABLE     f   CREATE TABLE public.acesso (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL
);
   DROP TABLE public.acesso;
       public         heap    postgres    false    5            ×            1259    34892    avaliacao_produto    TABLE     Ë   CREATE TABLE public.avaliacao_produto (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    nota integer NOT NULL,
    pessoa_id bigint NOT NULL,
    produto_id bigint NOT NULL
);
 %   DROP TABLE public.avaliacao_produto;
       public         heap    postgres    false    5            Ø            1259    34897    categoria_produto    TABLE     q   CREATE TABLE public.categoria_produto (
    id bigint NOT NULL,
    nome_desc character varying(255) NOT NULL
);
 %   DROP TABLE public.categoria_produto;
       public         heap    postgres    false    5            Ù            1259    34902    conta_pagar    TABLE     \  CREATE TABLE public.conta_pagar (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    dt_pagamento date,
    dt_vencimento date NOT NULL,
    status character varying(255) NOT NULL,
    valor_desconto numeric(19,2),
    valor_total numeric(19,2) NOT NULL,
    pessoa_id bigint NOT NULL,
    pessoa_forn_id bigint NOT NULL
);
   DROP TABLE public.conta_pagar;
       public         heap    postgres    false    5            Ú            1259    34909
   conta_receber    TABLE     :  CREATE TABLE public.conta_receber (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    dt_pagamento date,
    dt_vencimento date NOT NULL,
    status character varying(255) NOT NULL,
    valor_desconto numeric(19,2),
    valor_total numeric(19,2) NOT NULL,
    pessoa_id bigint NOT NULL
);
 !   DROP TABLE public.conta_receber;
       public         heap    postgres    false    5            Û            1259    34916    cup_desc    TABLE     ×   CREATE TABLE public.cup_desc (
    id bigint NOT NULL,
    cod_desc character varying(255) NOT NULL,
    data_validade_cupom date NOT NULL,
    valor_porcent_desc numeric(19,2),
    valor_real_desc numeric(19,2)
);
   DROP TABLE public.cup_desc;
       public         heap    postgres    false    5            Ü            1259    34921    endereco    TABLE     ¼  CREATE TABLE public.endereco (
    id bigint NOT NULL,
    bairro character varying(255) NOT NULL,
    cep character varying(255) NOT NULL,
    cidade character varying(255) NOT NULL,
    complemento character varying(255),
    numero character varying(255) NOT NULL,
    rua_logradouro character varying(255) NOT NULL,
    tipo_endereco character varying(255) NOT NULL,
    uf character varying(255) NOT NULL,
    pessoa_id bigint NOT NULL
);
   DROP TABLE public.endereco;
       public         heap    postgres    false    5            Ý            1259    34928    forma_pagamento    TABLE     o   CREATE TABLE public.forma_pagamento (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL
);
 #   DROP TABLE public.forma_pagamento;
       public         heap    postgres    false    5            Þ            1259    34933    imagem_produto    TABLE     ¦   CREATE TABLE public.imagem_produto (
    id bigint NOT NULL,
    imagem_miniatura text NOT NULL,
    imagem_original text NOT NULL,
    produto_id bigint NOT NULL
);
 "   DROP TABLE public.imagem_produto;
       public         heap    postgres    false    5            ß            1259    34940    item_venda_loja    TABLE     ¼   CREATE TABLE public.item_venda_loja (
    id bigint NOT NULL,
    quantidade double precision NOT NULL,
    produto_id bigint NOT NULL,
    venda_compra_loja_virtual_id bigint NOT NULL
);
 #   DROP TABLE public.item_venda_loja;
       public         heap    postgres    false    5            à            1259    34945
   marca_produto    TABLE     m   CREATE TABLE public.marca_produto (
    id bigint NOT NULL,
    nome_desc character varying(255) NOT NULL
);
 !   DROP TABLE public.marca_produto;
       public         heap    postgres    false    5            á            1259    34950    nota_fiscal_compra    TABLE     ¡  CREATE TABLE public.nota_fiscal_compra (
    id bigint NOT NULL,
    data_compra date NOT NULL,
    descricao_obs character varying(255),
    numero_nota character varying(255) NOT NULL,
    serie_nota character varying(255) NOT NULL,
    valor_desconto numeric(19,2),
    valor_icms numeric(19,2) NOT NULL,
    valor_total numeric(19,2) NOT NULL,
    conta_pagar_id bigint NOT NULL,
    pessoa_id bigint NOT NULL
);
 &   DROP TABLE public.nota_fiscal_compra;
       public         heap    postgres    false    5            â            1259    34957    nota_fiscal_venda    TABLE        CREATE TABLE public.nota_fiscal_venda (
    id bigint NOT NULL,
    numero character varying(255) NOT NULL,
    pdf text NOT NULL,
    serie character varying(255) NOT NULL,
    tipo character varying(255) NOT NULL,
    xml text NOT NULL,
    venda_compra_loja_virtual bigint NOT NULL
);
 %   DROP TABLE public.nota_fiscal_venda;
       public         heap    postgres    false    5            ã            1259    34964    nota_item_produto    TABLE     ·   CREATE TABLE public.nota_item_produto (
    id bigint NOT NULL,
    quantidade double precision NOT NULL,
    nota_fiscal_compra_id bigint NOT NULL,
    produto_id bigint NOT NULL
);
 %   DROP TABLE public.nota_item_produto;
       public         heap    postgres    false    5            ä            1259    34969    pessoa    TABLE     º   CREATE TABLE public.pessoa (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    telefone character varying(255) NOT NULL
);
    DROP TABLE public.pessoa;
       public         heap    postgres    false    5            å            1259    34976
   pessoa_fisica    TABLE     ˆ   CREATE TABLE public.pessoa_fisica (
    cpf character varying(255) NOT NULL,
    data_nascimento date,
    pessoa_id bigint NOT NULL
);
 !   DROP TABLE public.pessoa_fisica;
       public         heap    postgres    false    5            æ            1259    34981    pessoa_juridica    TABLE     R  CREATE TABLE public.pessoa_juridica (
    categoria character varying(255),
    cnpj character varying(255) NOT NULL,
    insc_estadual character varying(255),
    insc_municipal character varying(255),
    nome_fanstasia character varying(255) NOT NULL,
    razao_social character varying(255) NOT NULL,
    pessoa_id bigint NOT NULL
);
 #   DROP TABLE public.pessoa_juridica;
       public         heap    postgres    false    5            ç            1259    34988    produto    TABLE     7  CREATE TABLE public.produto (
    id bigint NOT NULL,
    alertar_qtde_estoque boolean,
    altura double precision NOT NULL,
    ativo boolean NOT NULL,
    descricao text NOT NULL,
    largura double precision NOT NULL,
    link_youtube character varying(255),
    nome character varying(255) NOT NULL,
    peso double precision NOT NULL,
    profundidade double precision NOT NULL,
    qtd_alerta_estoque integer,
    qtd_clique integer,
    qtd_estoque integer NOT NULL,
    tipo_unidade character varying(255) NOT NULL,
    valor_venda numeric(19,2) NOT NULL
);
    DROP TABLE public.produto;
       public         heap    postgres    false    5            ì            1259    35021
   seq_acesso    SEQUENCE     s   CREATE SEQUENCE public.seq_acesso
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.seq_acesso;
       public          postgres    false    5            í            1259    35022    seq_avaliacao_produto    SEQUENCE     ~   CREATE SEQUENCE public.seq_avaliacao_produto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.seq_avaliacao_produto;
       public          postgres    false    5            î            1259    35023    seq_categoria_produto    SEQUENCE     ~   CREATE SEQUENCE public.seq_categoria_produto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.seq_categoria_produto;
       public          postgres    false    5            ï            1259    35024    seq_conta_pagar    SEQUENCE     x   CREATE SEQUENCE public.seq_conta_pagar
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.seq_conta_pagar;
       public          postgres    false    5            ð            1259    35025    seq_conta_receber    SEQUENCE     z   CREATE SEQUENCE public.seq_conta_receber
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.seq_conta_receber;
       public          postgres    false    5            ñ            1259    35026    seq_cup_desc    SEQUENCE     u   CREATE SEQUENCE public.seq_cup_desc
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.seq_cup_desc;
       public          postgres    false    5            ò            1259    35027    seq_endereco    SEQUENCE     u   CREATE SEQUENCE public.seq_endereco
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.seq_endereco;
       public          postgres    false    5            ó            1259    35028    seq_forma_pagamento    SEQUENCE     |   CREATE SEQUENCE public.seq_forma_pagamento
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.seq_forma_pagamento;
       public          postgres    false    5            ô            1259    35029    seq_imagem_produto    SEQUENCE     {   CREATE SEQUENCE public.seq_imagem_produto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.seq_imagem_produto;
       public          postgres    false    5            õ            1259    35030    seq_item_venda_loja    SEQUENCE     |   CREATE SEQUENCE public.seq_item_venda_loja
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.seq_item_venda_loja;
       public          postgres    false    5            ö            1259    35031    seq_marca_produto    SEQUENCE     z   CREATE SEQUENCE public.seq_marca_produto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.seq_marca_produto;
       public          postgres    false    5            ÷            1259    35032    seq_nota_fiscal_compra    SEQUENCE        CREATE SEQUENCE public.seq_nota_fiscal_compra
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.seq_nota_fiscal_compra;
       public          postgres    false    5            ø            1259    35033    seq_nota_fiscal_venda    SEQUENCE     ~   CREATE SEQUENCE public.seq_nota_fiscal_venda
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.seq_nota_fiscal_venda;
       public          postgres    false    5            ù            1259    35034    seq_nota_item_produto    SEQUENCE     ~   CREATE SEQUENCE public.seq_nota_item_produto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.seq_nota_item_produto;
       public          postgres    false    5            ú            1259    35035
   seq_pessoa    SEQUENCE     s   CREATE SEQUENCE public.seq_pessoa
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.seq_pessoa;
       public          postgres    false    5            û            1259    35036    seq_produto    SEQUENCE     t   CREATE SEQUENCE public.seq_produto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.seq_produto;
       public          postgres    false    5            ü            1259    35037    seq_status_rastreio    SEQUENCE     |   CREATE SEQUENCE public.seq_status_rastreio
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.seq_status_rastreio;
       public          postgres    false    5            ý            1259    35038    seq_usuario    SEQUENCE     t   CREATE SEQUENCE public.seq_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.seq_usuario;
       public          postgres    false    5            þ            1259    35039    seq_venda_compra_loja_virtual    SEQUENCE     †   CREATE SEQUENCE public.seq_venda_compra_loja_virtual
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.seq_venda_compra_loja_virtual;
       public          postgres    false    5            è            1259    34995    status_rastreio    TABLE       CREATE TABLE public.status_rastreio (
    id bigint NOT NULL,
    centro_distribuicao character varying(255),
    cidade character varying(255),
    estado character varying(255),
    status character varying(255),
    venda_compra_loja_virtual_id bigint NOT NULL
);
 #   DROP TABLE public.status_rastreio;
       public         heap    postgres    false    5            é            1259    35002    usuario    TABLE     Ñ   CREATE TABLE public.usuario (
    id bigint NOT NULL,
    data_atual_senha date NOT NULL,
    login character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    pessoa_id bigint NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false    5            ê            1259    35009    usuarios_acesso    TABLE     g   CREATE TABLE public.usuarios_acesso (
    usuario_id bigint NOT NULL,
    acesso_id bigint NOT NULL
);
 #   DROP TABLE public.usuarios_acesso;
       public         heap    postgres    false    5            ë            1259    35012    venda_compra_loja_virtual    TABLE     ý  CREATE TABLE public.venda_compra_loja_virtual (
    id bigint NOT NULL,
    data_entrega date NOT NULL,
    data_venda date NOT NULL,
    dias_entrega integer NOT NULL,
    valor_desconto numeric(19,2),
    valor_frete numeric(19,2) NOT NULL,
    valor_total numeric(19,2) NOT NULL,
    cup_desconto_id bigint,
    endereco_cobranca_id bigint NOT NULL,
    endereco_entrega_id bigint NOT NULL,
    forma_pagamento_id bigint NOT NULL,
    nota_fiscal_venda_id bigint NOT NULL,
    pessoa_id bigint NOT NULL
);
 -   DROP TABLE public.venda_compra_loja_virtual;
       public         heap    postgres    false    5            Ÿ
          0    34887    acesso
   TABLE DATA           /   COPY public.acesso (id, descricao) FROM stdin;
    public          postgres    false    214   …«        
          0    34892    avaliacao_produto
   TABLE DATA           W   COPY public.avaliacao_produto (id, descricao, nota, pessoa_id, produto_id) FROM stdin;
    public          postgres    false    215   ¢«       ¡
          0    34897    categoria_produto
   TABLE DATA           :   COPY public.categoria_produto (id, nome_desc) FROM stdin;
    public          postgres    false    216   Ô«       ¢
          0    34902    conta_pagar
   TABLE DATA           ‘   COPY public.conta_pagar (id, descricao, dt_pagamento, dt_vencimento, status, valor_desconto, valor_total, pessoa_id, pessoa_forn_id) FROM stdin;
    public          postgres    false    217   ñ«       £
          0    34909
   conta_receber
   TABLE DATA           ƒ   COPY public.conta_receber (id, descricao, dt_pagamento, dt_vencimento, status, valor_desconto, valor_total, pessoa_id) FROM stdin;
    public          postgres    false    218   ¬       ¤
          0    34916    cup_desc
   TABLE DATA           j   COPY public.cup_desc (id, cod_desc, data_validade_cupom, valor_porcent_desc, valor_real_desc) FROM stdin;
    public          postgres    false    219   +¬       ¥
          0    34921    endereco
   TABLE DATA           ~   COPY public.endereco (id, bairro, cep, cidade, complemento, numero, rua_logradouro, tipo_endereco, uf, pessoa_id) FROM stdin;
    public          postgres    false    220   H¬       ¦
          0    34928    forma_pagamento
   TABLE DATA           8   COPY public.forma_pagamento (id, descricao) FROM stdin;
    public          postgres    false    221   e¬       §
          0    34933    imagem_produto
   TABLE DATA           [   COPY public.imagem_produto (id, imagem_miniatura, imagem_original, produto_id) FROM stdin;
    public          postgres    false    222   ‚¬       ¨
          0    34940    item_venda_loja
   TABLE DATA           c   COPY public.item_venda_loja (id, quantidade, produto_id, venda_compra_loja_virtual_id) FROM stdin;
    public          postgres    false    223   Ÿ¬       ©
          0    34945
   marca_produto
   TABLE DATA           6   COPY public.marca_produto (id, nome_desc) FROM stdin;
    public          postgres    false    224   ¼¬       ª
          0    34950    nota_fiscal_compra
   TABLE DATA           ©   COPY public.nota_fiscal_compra (id, data_compra, descricao_obs, numero_nota, serie_nota, valor_desconto, valor_icms, valor_total, conta_pagar_id, pessoa_id) FROM stdin;
    public          postgres    false    225   Ù¬       «
          0    34957    nota_fiscal_venda
   TABLE DATA           i   COPY public.nota_fiscal_venda (id, numero, pdf, serie, tipo, xml, venda_compra_loja_virtual) FROM stdin;
    public          postgres    false    226   ö¬       ¬
          0    34964    nota_item_produto
   TABLE DATA           ^   COPY public.nota_item_produto (id, quantidade, nota_fiscal_compra_id, produto_id) FROM stdin;
    public          postgres    false    227   ­       ­
          0    34969    pessoa
   TABLE DATA           ;   COPY public.pessoa (id, email, nome, telefone) FROM stdin;
    public          postgres    false    228   0­       ®
          0    34976
   pessoa_fisica
   TABLE DATA           H   COPY public.pessoa_fisica (cpf, data_nascimento, pessoa_id) FROM stdin;
    public          postgres    false    229   6®       ¯
          0    34981    pessoa_juridica
   TABLE DATA           ‚   COPY public.pessoa_juridica (categoria, cnpj, insc_estadual, insc_municipal, nome_fanstasia, razao_social, pessoa_id) FROM stdin;
    public          postgres    false    230   Ÿ®       °
          0    34988    produto
   TABLE DATA           Î   COPY public.produto (id, alertar_qtde_estoque, altura, ativo, descricao, largura, link_youtube, nome, peso, profundidade, qtd_alerta_estoque, qtd_clique, qtd_estoque, tipo_unidade, valor_venda) FROM stdin;
    public          postgres    false    231   B¯       ±
          0    34995    status_rastreio
   TABLE DATA           x   COPY public.status_rastreio (id, centro_distribuicao, cidade, estado, status, venda_compra_loja_virtual_id) FROM stdin;
    public          postgres    false    232   Š¯       ²
          0    35002    usuario
   TABLE DATA           P   COPY public.usuario (id, data_atual_senha, login, senha, pessoa_id) FROM stdin;
    public          postgres    false    233   §¯       ³
          0    35009    usuarios_acesso
   TABLE DATA           @   COPY public.usuarios_acesso (usuario_id, acesso_id) FROM stdin;
    public          postgres    false    234   Ä¯       ´
          0    35012    venda_compra_loja_virtual
   TABLE DATA           ú   COPY public.venda_compra_loja_virtual (id, data_entrega, data_venda, dias_entrega, valor_desconto, valor_frete, valor_total, cup_desconto_id, endereco_cobranca_id, endereco_entrega_id, forma_pagamento_id, nota_fiscal_venda_id, pessoa_id) FROM stdin;
    public          postgres    false    235   á¯       Ï
           0    0
   seq_acesso    SEQUENCE SET     9   SELECT pg_catalog.setval('public.seq_acesso', 1, false);
          public          postgres    false    236            Ð
           0    0    seq_avaliacao_produto    SEQUENCE SET     D   SELECT pg_catalog.setval('public.seq_avaliacao_produto', 1, false);
          public          postgres    false    237            Ñ
           0    0    seq_categoria_produto    SEQUENCE SET     D   SELECT pg_catalog.setval('public.seq_categoria_produto', 1, false);
          public          postgres    false    238            Ò
           0    0    seq_conta_pagar    SEQUENCE SET     >   SELECT pg_catalog.setval('public.seq_conta_pagar', 1, false);
          public          postgres    false    239            Ó
           0    0    seq_conta_receber    SEQUENCE SET     @   SELECT pg_catalog.setval('public.seq_conta_receber', 1, false);
          public          postgres    false    240            Ô
           0    0    seq_cup_desc    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.seq_cup_desc', 1, false);
          public          postgres    false    241            Õ
           0    0    seq_endereco    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.seq_endereco', 1, false);
          public          postgres    false    242            Ö
           0    0    seq_forma_pagamento    SEQUENCE SET     B   SELECT pg_catalog.setval('public.seq_forma_pagamento', 1, false);
          public          postgres    false    243            ×
           0    0    seq_imagem_produto    SEQUENCE SET     A   SELECT pg_catalog.setval('public.seq_imagem_produto', 1, false);
          public          postgres    false    244            Ø
           0    0    seq_item_venda_loja    SEQUENCE SET     B   SELECT pg_catalog.setval('public.seq_item_venda_loja', 1, false);
          public          postgres    false    245            Ù
           0    0    seq_marca_produto    SEQUENCE SET     @   SELECT pg_catalog.setval('public.seq_marca_produto', 1, false);
          public          postgres    false    246            Ú
           0    0    seq_nota_fiscal_compra    SEQUENCE SET     E   SELECT pg_catalog.setval('public.seq_nota_fiscal_compra', 1, false);
          public          postgres    false    247            Û
           0    0    seq_nota_fiscal_venda    SEQUENCE SET     D   SELECT pg_catalog.setval('public.seq_nota_fiscal_venda', 1, false);
          public          postgres    false    248            Ü
           0    0    seq_nota_item_produto    SEQUENCE SET     D   SELECT pg_catalog.setval('public.seq_nota_item_produto', 1, false);
          public          postgres    false    249            Ý
           0    0
   seq_pessoa    SEQUENCE SET     9   SELECT pg_catalog.setval('public.seq_pessoa', 38, true);
          public          postgres    false    250            Þ
           0    0    seq_produto    SEQUENCE SET     :   SELECT pg_catalog.setval('public.seq_produto', 1, false);
          public          postgres    false    251            ß
           0    0    seq_status_rastreio    SEQUENCE SET     B   SELECT pg_catalog.setval('public.seq_status_rastreio', 1, false);
          public          postgres    false    252            à
           0    0    seq_usuario    SEQUENCE SET     :   SELECT pg_catalog.setval('public.seq_usuario', 1, false);
          public          postgres    false    253            á
           0    0    seq_venda_compra_loja_virtual    SEQUENCE SET     L   SELECT pg_catalog.setval('public.seq_venda_compra_loja_virtual', 1, false);
          public          postgres    false    254            Ì           2606    34891    acesso acesso_pkey
   CONSTRAINT     P   ALTER TABLE ONLY public.acesso
    ADD CONSTRAINT acesso_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.acesso DROP CONSTRAINT acesso_pkey;
       public            postgres    false    214            Î           2606    34896 (   avaliacao_produto avaliacao_produto_pkey
   CONSTRAINT     f   ALTER TABLE ONLY public.avaliacao_produto
    ADD CONSTRAINT avaliacao_produto_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.avaliacao_produto DROP CONSTRAINT avaliacao_produto_pkey;
       public            postgres    false    215            Ð           2606    34901 (   categoria_produto categoria_produto_pkey
   CONSTRAINT     f   ALTER TABLE ONLY public.categoria_produto
    ADD CONSTRAINT categoria_produto_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.categoria_produto DROP CONSTRAINT categoria_produto_pkey;
       public            postgres    false    216            Ò           2606    34908    conta_pagar conta_pagar_pkey
   CONSTRAINT     Z   ALTER TABLE ONLY public.conta_pagar
    ADD CONSTRAINT conta_pagar_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.conta_pagar DROP CONSTRAINT conta_pagar_pkey;
       public            postgres    false    217            Ô           2606    34915     conta_receber conta_receber_pkey
   CONSTRAINT     ^   ALTER TABLE ONLY public.conta_receber
    ADD CONSTRAINT conta_receber_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.conta_receber DROP CONSTRAINT conta_receber_pkey;
       public            postgres    false    218            Ö           2606    34920    cup_desc cup_desc_pkey
   CONSTRAINT     T   ALTER TABLE ONLY public.cup_desc
    ADD CONSTRAINT cup_desc_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.cup_desc DROP CONSTRAINT cup_desc_pkey;
       public            postgres    false    219            Ø           2606    34927    endereco endereco_pkey
   CONSTRAINT     T   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
       public            postgres    false    220            Ú           2606    34932 $   forma_pagamento forma_pagamento_pkey
   CONSTRAINT     b   ALTER TABLE ONLY public.forma_pagamento
    ADD CONSTRAINT forma_pagamento_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.forma_pagamento DROP CONSTRAINT forma_pagamento_pkey;
       public            postgres    false    221            Ü           2606    34939 "   imagem_produto imagem_produto_pkey
   CONSTRAINT     `   ALTER TABLE ONLY public.imagem_produto
    ADD CONSTRAINT imagem_produto_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.imagem_produto DROP CONSTRAINT imagem_produto_pkey;
       public            postgres    false    222            Þ           2606    34944 $   item_venda_loja item_venda_loja_pkey
   CONSTRAINT     b   ALTER TABLE ONLY public.item_venda_loja
    ADD CONSTRAINT item_venda_loja_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.item_venda_loja DROP CONSTRAINT item_venda_loja_pkey;
       public            postgres    false    223            à           2606    34949     marca_produto marca_produto_pkey
   CONSTRAINT     ^   ALTER TABLE ONLY public.marca_produto
    ADD CONSTRAINT marca_produto_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.marca_produto DROP CONSTRAINT marca_produto_pkey;
       public            postgres    false    224            â           2606    34956 *   nota_fiscal_compra nota_fiscal_compra_pkey
   CONSTRAINT     h   ALTER TABLE ONLY public.nota_fiscal_compra
    ADD CONSTRAINT nota_fiscal_compra_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.nota_fiscal_compra DROP CONSTRAINT nota_fiscal_compra_pkey;
       public            postgres    false    225            ä           2606    34963 (   nota_fiscal_venda nota_fiscal_venda_pkey
   CONSTRAINT     f   ALTER TABLE ONLY public.nota_fiscal_venda
    ADD CONSTRAINT nota_fiscal_venda_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.nota_fiscal_venda DROP CONSTRAINT nota_fiscal_venda_pkey;
       public            postgres    false    226            æ           2606    34968 (   nota_item_produto nota_item_produto_pkey
   CONSTRAINT     f   ALTER TABLE ONLY public.nota_item_produto
    ADD CONSTRAINT nota_item_produto_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.nota_item_produto DROP CONSTRAINT nota_item_produto_pkey;
       public            postgres    false    227            ê           2606    34980     pessoa_fisica pessoa_fisica_pkey
   CONSTRAINT     e   ALTER TABLE ONLY public.pessoa_fisica
    ADD CONSTRAINT pessoa_fisica_pkey PRIMARY KEY (pessoa_id);
 J   ALTER TABLE ONLY public.pessoa_fisica DROP CONSTRAINT pessoa_fisica_pkey;
       public            postgres    false    229            ì           2606    34987 $   pessoa_juridica pessoa_juridica_pkey
   CONSTRAINT     i   ALTER TABLE ONLY public.pessoa_juridica
    ADD CONSTRAINT pessoa_juridica_pkey PRIMARY KEY (pessoa_id);
 N   ALTER TABLE ONLY public.pessoa_juridica DROP CONSTRAINT pessoa_juridica_pkey;
       public            postgres    false    230            è           2606    34975    pessoa pessoa_pkey
   CONSTRAINT     P   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public            postgres    false    228            î           2606    34994    produto produto_pkey
   CONSTRAINT     R   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public            postgres    false    231            ð           2606    35001 $   status_rastreio status_rastreio_pkey
   CONSTRAINT     b   ALTER TABLE ONLY public.status_rastreio
    ADD CONSTRAINT status_rastreio_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.status_rastreio DROP CONSTRAINT status_rastreio_pkey;
       public            postgres    false    232            ô           2606    35020 "   usuarios_acesso unique_acesso_user
   CONSTRAINT     n   ALTER TABLE ONLY public.usuarios_acesso
    ADD CONSTRAINT unique_acesso_user UNIQUE (usuario_id, acesso_id);
 L   ALTER TABLE ONLY public.usuarios_acesso DROP CONSTRAINT unique_acesso_user;
       public            postgres    false    234    234            ò           2606    35008    usuario usuario_pkey
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    233            ö           2606    35016 8   venda_compra_loja_virtual venda_compra_loja_virtual_pkey
   CONSTRAINT     v   ALTER TABLE ONLY public.venda_compra_loja_virtual
    ADD CONSTRAINT venda_compra_loja_virtual_pkey PRIMARY KEY (id);
 b   ALTER TABLE ONLY public.venda_compra_loja_virtual DROP CONSTRAINT venda_compra_loja_virtual_pkey;
       public            postgres    false    235   
           2606    35130    usuarios_acesso acesso_fk
   FK CONSTRAINT     {   ALTER TABLE ONLY public.usuarios_acesso
    ADD CONSTRAINT acesso_fk FOREIGN KEY (acesso_id) REFERENCES public.acesso(id);
 C   ALTER TABLE ONLY public.usuarios_acesso DROP CONSTRAINT acesso_fk;
       public          postgres    false    3276    214    234   
           2606    35085 !   nota_fiscal_compra conta_pagar_fk
   FK CONSTRAINT        ALTER TABLE ONLY public.nota_fiscal_compra
    ADD CONSTRAINT conta_pagar_fk FOREIGN KEY (conta_pagar_id) REFERENCES public.conta_pagar(id);
 K   ALTER TABLE ONLY public.nota_fiscal_compra DROP CONSTRAINT conta_pagar_fk;
       public          postgres    false    217    3282    225            
           2606    35140 )   venda_compra_loja_virtual cup_desconto_fk
   FK CONSTRAINT     “   ALTER TABLE ONLY public.venda_compra_loja_virtual
    ADD CONSTRAINT cup_desconto_fk FOREIGN KEY (cup_desconto_id) REFERENCES public.cup_desc(id);
 S   ALTER TABLE ONLY public.venda_compra_loja_virtual DROP CONSTRAINT cup_desconto_fk;
       public          postgres    false    235    219    3286            
           2606    35145 .   venda_compra_loja_virtual endereco_cobranca_fk
   FK CONSTRAINT        ALTER TABLE ONLY public.venda_compra_loja_virtual
    ADD CONSTRAINT endereco_cobranca_fk FOREIGN KEY (endereco_cobranca_id) REFERENCES public.endereco(id);
 X   ALTER TABLE ONLY public.venda_compra_loja_virtual DROP CONSTRAINT endereco_cobranca_fk;
       public          postgres    false    3288    235    220   

           2606    35150 -   venda_compra_loja_virtual endereco_entrega_pk
   FK CONSTRAINT     ›   ALTER TABLE ONLY public.venda_compra_loja_virtual
    ADD CONSTRAINT endereco_entrega_pk FOREIGN KEY (endereco_entrega_id) REFERENCES public.endereco(id);
 W   ALTER TABLE ONLY public.venda_compra_loja_virtual DROP CONSTRAINT endereco_entrega_pk;
       public          postgres    false    220    3288    235            
           2606    35155 ,   venda_compra_loja_virtual forma_pagamento_fk
   FK CONSTRAINT         ALTER TABLE ONLY public.venda_compra_loja_virtual
    ADD CONSTRAINT forma_pagamento_fk FOREIGN KEY (forma_pagamento_id) REFERENCES public.forma_pagamento(id);
 V   ALTER TABLE ONLY public.venda_compra_loja_virtual DROP CONSTRAINT forma_pagamento_fk;
       public          postgres    false    3290    235    221            
           2606    35100 '   nota_item_produto nota_fiscal_compra_fk
   FK CONSTRAINT     ¡   ALTER TABLE ONLY public.nota_item_produto
    ADD CONSTRAINT nota_fiscal_compra_fk FOREIGN KEY (nota_fiscal_compra_id) REFERENCES public.nota_fiscal_compra(id);
 Q   ALTER TABLE ONLY public.nota_item_produto DROP CONSTRAINT nota_fiscal_compra_fk;
       public          postgres    false    225    3298    227            
           2606    35160 .   venda_compra_loja_virtual nota_fiscal_venda_fk
   FK CONSTRAINT     ¦   ALTER TABLE ONLY public.venda_compra_loja_virtual
    ADD CONSTRAINT nota_fiscal_venda_fk FOREIGN KEY (nota_fiscal_venda_id) REFERENCES public.nota_fiscal_venda(id);
 X   ALTER TABLE ONLY public.venda_compra_loja_virtual DROP CONSTRAINT nota_fiscal_venda_fk;
       public          postgres    false    235    3300    226            ÷           2606    35040    avaliacao_produto pessoa_fk
   FK CONSTRAINT     }   ALTER TABLE ONLY public.avaliacao_produto
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 E   ALTER TABLE ONLY public.avaliacao_produto DROP CONSTRAINT pessoa_fk;
       public          postgres    false    228    215    3304            ù           2606    35050    conta_pagar pessoa_fk
   FK CONSTRAINT     w   ALTER TABLE ONLY public.conta_pagar
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 ?   ALTER TABLE ONLY public.conta_pagar DROP CONSTRAINT pessoa_fk;
       public          postgres    false    3304    217    228            û           2606    35060    conta_receber pessoa_fk
   FK CONSTRAINT     y   ALTER TABLE ONLY public.conta_receber
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 A   ALTER TABLE ONLY public.conta_receber DROP CONSTRAINT pessoa_fk;
       public          postgres    false    218    3304    228            ü           2606    35065    endereco pessoa_fk
   FK CONSTRAINT     t   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 <   ALTER TABLE ONLY public.endereco DROP CONSTRAINT pessoa_fk;
       public          postgres    false    220    228    3304            
           2606    35090    nota_fiscal_compra pessoa_fk
   FK CONSTRAINT     ~   ALTER TABLE ONLY public.nota_fiscal_compra
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 F   ALTER TABLE ONLY public.nota_fiscal_compra DROP CONSTRAINT pessoa_fk;
       public          postgres    false    225    3304    228            
           2606    35110    pessoa_fisica pessoa_fk
   FK CONSTRAINT     y   ALTER TABLE ONLY public.pessoa_fisica
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 A   ALTER TABLE ONLY public.pessoa_fisica DROP CONSTRAINT pessoa_fk;
       public          postgres    false    3304    229    228            
           2606    35115    pessoa_juridica pessoa_fk
   FK CONSTRAINT     {   ALTER TABLE ONLY public.pessoa_juridica
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 C   ALTER TABLE ONLY public.pessoa_juridica DROP CONSTRAINT pessoa_fk;
       public          postgres    false    3304    230    228            
           2606    35125    usuario pessoa_fk
   FK CONSTRAINT     s   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 ;   ALTER TABLE ONLY public.usuario DROP CONSTRAINT pessoa_fk;
       public          postgres    false    3304    233    228            
           2606    35165 #   venda_compra_loja_virtual pessoa_fk
   FK CONSTRAINT     …   ALTER TABLE ONLY public.venda_compra_loja_virtual
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
 M   ALTER TABLE ONLY public.venda_compra_loja_virtual DROP CONSTRAINT pessoa_fk;
       public          postgres    false    235    228    3304            ú           2606    35055    conta_pagar pessoa_forn_fk
   FK CONSTRAINT        ALTER TABLE ONLY public.conta_pagar
    ADD CONSTRAINT pessoa_forn_fk FOREIGN KEY (pessoa_forn_id) REFERENCES public.pessoa(id);
 D   ALTER TABLE ONLY public.conta_pagar DROP CONSTRAINT pessoa_forn_fk;
       public          postgres    false    3304    217    228            ø           2606    35045    avaliacao_produto produto_fk
   FK CONSTRAINT     €   ALTER TABLE ONLY public.avaliacao_produto
    ADD CONSTRAINT produto_fk FOREIGN KEY (produto_id) REFERENCES public.produto(id);
 F   ALTER TABLE ONLY public.avaliacao_produto DROP CONSTRAINT produto_fk;
       public          postgres    false    231    215    3310            ý           2606    35070    imagem_produto produto_fk
   FK CONSTRAINT     }   ALTER TABLE ONLY public.imagem_produto
    ADD CONSTRAINT produto_fk FOREIGN KEY (produto_id) REFERENCES public.produto(id);
 C   ALTER TABLE ONLY public.imagem_produto DROP CONSTRAINT produto_fk;
       public          postgres    false    231    3310    222            þ           2606    35075    item_venda_loja produto_fk
   FK CONSTRAINT     ~   ALTER TABLE ONLY public.item_venda_loja
    ADD CONSTRAINT produto_fk FOREIGN KEY (produto_id) REFERENCES public.produto(id);
 D   ALTER TABLE ONLY public.item_venda_loja DROP CONSTRAINT produto_fk;
       public          postgres    false    3310    223    231            
           2606    35105    nota_item_produto produto_fk
   FK CONSTRAINT     €   ALTER TABLE ONLY public.nota_item_produto
    ADD CONSTRAINT produto_fk FOREIGN KEY (produto_id) REFERENCES public.produto(id);
 F   ALTER TABLE ONLY public.nota_item_produto DROP CONSTRAINT produto_fk;
       public          postgres    false    227    231    3310   

           2606    35135    usuarios_acesso usuario_fk
   FK CONSTRAINT     ~   ALTER TABLE ONLY public.usuarios_acesso
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 D   ALTER TABLE ONLY public.usuarios_acesso DROP CONSTRAINT usuario_fk;
       public          postgres    false    234    233    3314            ÿ           2606    35080 ,   item_venda_loja venda_compra_loja_virtual_fk
   FK CONSTRAINT     ´   ALTER TABLE ONLY public.item_venda_loja
    ADD CONSTRAINT venda_compra_loja_virtual_fk FOREIGN KEY (venda_compra_loja_virtual_id) REFERENCES public.venda_compra_loja_virtual(id);
 V   ALTER TABLE ONLY public.item_venda_loja DROP CONSTRAINT venda_compra_loja_virtual_fk;
       public          postgres    false    235    223    3318            
           2606    35095 .   nota_fiscal_venda venda_compra_loja_virtual_pk
   FK CONSTRAINT     ³   ALTER TABLE ONLY public.nota_fiscal_venda
    ADD CONSTRAINT venda_compra_loja_virtual_pk FOREIGN KEY (venda_compra_loja_virtual) REFERENCES public.venda_compra_loja_virtual(id);
 X   ALTER TABLE ONLY public.nota_fiscal_venda DROP CONSTRAINT venda_compra_loja_virtual_pk;
       public          postgres    false    226    3318    235            
           2606    35120 ,   status_rastreio venda_compra_loja_virtual_pk
   FK CONSTRAINT     ´   ALTER TABLE ONLY public.status_rastreio
    ADD CONSTRAINT venda_compra_loja_virtual_pk FOREIGN KEY (venda_compra_loja_virtual_id) REFERENCES public.venda_compra_loja_virtual(id);
 V   ALTER TABLE ONLY public.status_rastreio DROP CONSTRAINT venda_compra_loja_virtual_pk;
       public          postgres    false    235    3318    232            Ÿ

   xœ‹Ñãââ Å ©       
   "   xœ3äLIK/NOKaNCNCNC.#l‚1z\\\ ?ÿà      ¡

   xœ‹Ñãââ Å ©      ¢

   xœ‹Ñãââ Å ©      £

   xœ‹Ñãââ Å ©      ¤

   xœ‹Ñãââ Å ©      ¥

   xœ‹Ñãââ Å ©      ¦

   xœ‹Ñãââ Å ©      §

   xœ‹Ñãââ Å ©      ¨

   xœ‹Ñãââ Å ©      ©

   xœ‹Ñãââ Å ©      ª

   xœ‹Ñãââ Å ©      «

   xœ‹Ñãââ Å ©      ¬

   xœ‹Ñãââ Å ©      ­
   ö   xœ¥Ñ;ŽÂ0€áÚ>XEÌ¤KCCA±5•8
Iœ‰pXí}8
‚´Ú2ÒØ’[óËúÀ4CQÔîÇÇœ/cÇÜ&_SÅ²i«ºŒ®iËÊ¤MË’iØqî]:Ÿ<ŸîùveH«õf›fve
îG7rN}í|Î>ºéií¦ý<þFfv=?só~æƒ_|û8pÿè»×å¿Àv>ªÙ| –ª€ º„À>àJjÐYƒ tÚ àF7
¸QÇnÔq£€uÜ(àF7
¸IÇMnÒq“€›tÜ$à&7	¸IÇ}L¬µwŠ5T       ®
   Y   xœmÐ±
À0ÄÀÚÚÅÿ%ÛÑ.ÙŽ,À–Í\½î>¯ªÏP÷òÔ;érÕðrÍu¦=Ú†v¡54"RDŒÈA&È™ d‚·”åï‰ˆ¹EØ      ¯
   “   xœµÑ±
Â@„ázï)î	Bnvg)˜€àYYÚ,$`ŠD1yLZû©vØâo¾Ò^%AíÐó©Þ—@aûUƒé6 ÷÷4ÄÎçÕ—Ñcï±ŒóËc;}¾Ãâñö¸œåïµö^‰…ÂÌ7Ü|ææSMîƒÜ'ë&2o"û‚ì²/È¾ û‚ì«d_%û*ÙWÉ¾šÃ³
!ü ÿè×d      °
   8   xœ3ä,á44 i)éÅ)i NŒ'•žž’VÂ !AÎP?_ e g`À£ÇÅÅ XÕ      ±

   xœ‹Ñãââ Å ©      ²

   xœ‹Ñãââ Å ©      ³

   xœ‹Ñãââ Å ©      ´

   xœ‹Ñãââ Å ©