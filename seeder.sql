use closet_db;
insert into users (username, email, password, open)
values(
          'BigParrot',
          'BirdGuy@email.com',
          'password',
          true
          ),(
          'RainbowUnicorn',
          'colors@email.com',
          'password',
          true
          ),(
          'NobleBadger',
          'honey@email.com',
          'password',
          false
          ),(
          'TacoCat',
          'palindrome@email.com',
          'password',
          true
          ),(
          'DazzlingStingray',
          'aquaticwonder@email.com',
          'password',
          true
          ),(
          'FancyTailfeathers',
          'hawk@email.com',
          'password',
          false
          ),(
          'UselessWeapon',
          'gunblade@jrpg.com',
          'password',
          true
          );

insert into category (name)
values(
'Shirt'
),(
'Top'
),(
'Outerwear'
),(
'Hat/Cap'
),(
'Pants'
),(
'Shorts'
),(
'Leggings'
),(
'Dress'
),(
'Belt'
),(
'Scarf/Shawl'
),(
'Bag'
),(
'Swimwear'
),(
'Warm Weather'
),(
'Cold Weather'
),(
'Fall Weather'
),(
'Footwear'
),(
'Casual'
),(
'Formal'
),(
'Professional'
),(
'Sporty'
),(
'Going Out'
),(
'Staying In'
);




insert into garments (date, image, user_id)
values (
'22 October 2018',
'https://www.patagonia.com/dis/dw/image/v2/ABBM_PRD/on/demandware.static/-/Sites-patagonia-master/default/dw0b78138c/images/hi-res/27805_COI.jpg?sw=750&sh=750&sm=fit&sfrm=png',
1
),(
'24 October 2018',
'https://www.substation-safety.com/wp-content/uploads/2018/05/tranemo-5940-92-FR-T-shirt-Long-sleeves-750x750.jpg',
1
),(
'22 October 2018',
'https://www.patagonia.com/dis/dw/image/v2/ABBM_PRD/on/demandware.static/-/Sites-patagonia-master/default/dwe7863b74/images/hi-res/55910_MJVK.jpg?sw=750&sh=750&sm=fit&sfrm=png',
1
),(
'22 October 2018',
'https://www.larsmode.com/image/cache/catalog/LM4_6861-750x750.jpg',
1
),(
'22 October 2018',
'https://www.jubidubi.com/image/cache/wkseller/BEING%20353/style87/87-PRINTED-WHITE-750x750.jpg',
1
);


insert into garments_categories (garment_id, category_id)
values
(1,3),
(1,14),
(1,17),
(2,1),
(2,2),
(2,15),
(2,17),
(2,20),
(3,5),
(3,15),
(3,17),
(4,16),
(4,18),
(4,19),
(4,21),
(5,1),
(5,17),
(5,19),
(5,21);


insert into outfit (date, description, user_id)
values(
'22 October 2018',
'Sweet Threads',
1
);



insert into garments_outfits (outfit_id, garment_id)
values
(1,1),
(1,2),
(1,3),
(1,4);

insert into garments (date, image, user_id)
values (
           '22 October 2018',
           'https://www.patagonia.com/dis/dw/image/v2/ABBM_PRD/on/demandware.static/-/Sites-patagonia-master/default/dw0b78138c/images/hi-res/27805_COI.jpg?sw=750&sh=750&sm=fit&sfrm=png',
           1
           ),(
           '24 October 2018',
           'https://www.substation-safety.com/wp-content/uploads/2018/05/tranemo-5940-92-FR-T-shirt-Long-sleeves-750x750.jpg',
           1
           ),(
           '22 October 2018',
           'https://www.patagonia.com/dis/dw/image/v2/ABBM_PRD/on/demandware.static/-/Sites-patagonia-master/default/dwe7863b74/images/hi-res/55910_MJVK.jpg?sw=750&sh=750&sm=fit&sfrm=png',
           1
           ),(
           '22 October 2018',
           'https://www.larsmode.com/image/cache/catalog/LM4_6861-750x750.jpg',
           1
           ),(
           '22 October 2018',
           'https://www.jubidubi.com/image/cache/wkseller/BEING%20353/style87/87-PRINTED-WHITE-750x750.jpg',
           1
           );