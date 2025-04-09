function A = net2mat(filename)
    fid = fopen(filename, 'r');
    tline = fgetl(fid);

    % 노드 수 파악
    while ischar(tline)
        if contains(lower(tline), '*vertices')
            parts = strsplit(tline);
            num_nodes = str2double(parts{2});
            break;
        end
        tline = fgetl(fid);
    end

    % 엣지로 이동
    while ischar(tline) && isempty(strfind(lower(tline), '*edges'))
        tline = fgetl(fid);
    end

    % 인접 행렬 초기화
    A = zeros(num_nodes);

    % 엣지 읽기
    tline = fgetl(fid);
    while ischar(tline)
        if isempty(tline) || startsWith(tline, '*')
            tline = fgetl(fid);
            continue;
        end
        parts = str2num(tline);  % 예: [1 2 1]
        if length(parts) >= 2
            i = parts(1);
            j = parts(2);
            A(i, j) = 1;
            A(j, i) = 1;  % 무방향 그래프
        end
        tline = fgetl(fid);
    end

    fclose(fid);
end
