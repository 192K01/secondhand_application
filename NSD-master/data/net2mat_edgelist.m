function [A, nodes] = net2mat_edgelist(filename)
    % 파일 읽기
    fid = fopen(filename, 'r');
    C = textscan(fid, '%s %s');  % edge list 읽기
    fclose(fid);

    % 단백질 ID 리스트 생성
    nodes = unique([C{1}; C{2}]);
    n = length(nodes);

    % ID → 인덱스 맵핑
    nodeMap = containers.Map(nodes, 1:n);

    % 인접 행렬 만들기
    A = zeros(n);
    for i = 1:length(C{1})
        u = nodeMap(C{1}{i});
        v = nodeMap(C{2}{i});
        A(u, v) = 1;
        A(v, u) = 1;  % 무방향 그래프
    end
end
